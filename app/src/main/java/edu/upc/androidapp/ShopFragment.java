package edu.upc.androidapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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
    List<Item> itemlist;
    private String id;
    Usuario user;
    TextView coins;
    int cashShop;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_shop, container,false);
        shopList = new ArrayList<>();
        coins=vista.findViewById(R.id.cash);
        recyclerShop = vista.findViewById(R.id.recyclerShop);
        recyclerShop.setLayoutManager(new LinearLayoutManager(getContext()));
        return vista;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<List<Item>> itemListCall =apiInterface.getItems();
        itemListCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                Log.d("TAG",response.code()+"");
                if(response.code()==201){
                    itemlist=response.body();
                    items.setItems(itemlist);
                    llenarLista(items,cashShop);


                }
            }
            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");
            }
        });
        id = getArguments().getString("ID");
        Call<Usuario> userCall =apiInterface.getUser(id);
        userCall.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                Log.d("TAG",response.code()+"");
                if(response.code()==200){
                    user=response.body();
                    ponerCash(user.getCash());

                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                call.cancel();
                Log.d("Error","Failure");
            }
        });

    }

    private void llenarLista(ItemList items, int cash) {
        List<Item> listItems = items.getItems();
        int size = listItems.size();
        for (int i = 0; i < size; i++) {
            String price = String.valueOf(items.getItem(i).getPrice());
            shopList.add(new ShopItem(items.getItem(i).getName(), items.getItem(i).getDescription(), items.getItem(i).getImage(), price));
        }
        ShopItemsAdapter adapter = new ShopItemsAdapter(shopList,id,cash);
        recyclerShop.setAdapter(adapter);
    }
    private void ponerCash(int cash){
        coins.setText("Coins: "+ String.valueOf(cash));
        cashShop=cash;
    }
}
