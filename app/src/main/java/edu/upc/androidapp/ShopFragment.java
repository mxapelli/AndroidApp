package edu.upc.androidapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopFragment extends Fragment {
    APIInterface apiInterface;
    RecyclerView recyclerShop;
    ArrayList<ShopItem> shopList;
    ItemList items= new ItemList();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_shop, container,false);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        shopList = new ArrayList<>();
        recyclerShop = vista.findViewById(R.id.recyclerShop);
        recyclerShop.setLayoutManager(new LinearLayoutManager(getContext()));
        llenarLista(items);
        Toast toast = Toast.makeText(getContext(),"Login failed! Please try again", Toast.LENGTH_LONG);
        toast.show();

        ShopItemsAdapter adapter = new ShopItemsAdapter(shopList);
        recyclerShop.setAdapter(adapter);
        return vista;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Call<ItemList> itemListCall =apiInterface.getItems();
        itemListCall.enqueue(new Callback<ItemList>() {
            @Override
            public void onResponse(Call<ItemList> call, Response<ItemList> response) {
                Log.d("TAG",response.code()+"");
                if(response.code()==201){
                    items=response.body();
                }
            }
            @Override
            public void onFailure(Call<ItemList> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");
            }
        });
    }

    private void llenarLista(ItemList items) {
        List<Item> listItems = items.getItems();
        int size = listItems.size();
        for (int i = 1; i <= size; i++) {
            String price = String.valueOf(items.getItem(i).getPrice());
            shopList.add(new ShopItem(items.getItem(i).getName(), items.getItem(i).getDescription(), i, price));
        }
    }
}
