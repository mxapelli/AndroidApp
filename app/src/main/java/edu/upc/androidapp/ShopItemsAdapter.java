package edu.upc.androidapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopItemsAdapter extends RecyclerView.Adapter<ShopItemsAdapter.ShopItemViewHolder> {
    ArrayList<ShopItem> shopList;
    String id;
    APIInterface apiInterface;
    Inventory inventory=new Inventory();
    int cash;
    Usuario user= new Usuario();


    public ShopItemsAdapter(ArrayList<ShopItem> shopList, String id, int cash) {
        this.shopList = shopList;
        this.id=id;
        this.cash=cash;

        apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    @NonNull
    @Override
    public ShopItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop_list, null, false);
        return new ShopItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemViewHolder holder, int position) {
        holder.txtName.setText(shopList.get(position).getName());
        holder.txtDescription.setText(shopList.get(position).getDescription());
        holder.txtPrice.setText(shopList.get(position).getPrice());
        String imageURL = shopList.get(position).getImageId();
        String[] urlImageFinal = imageURL.split("/");
        String imageName = urlImageFinal[1];
        String[] lastImageURL = imageName.split("\\.");
        String url = lastImageURL[0];
        int id = holder.image.getContext().getResources().getIdentifier(url, "drawable", holder.image.getContext().getPackageName());
        holder.image.setImageResource(id);

    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }


    public class ShopItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDescription, txtPrice, coins;
        ImageView image;
        Button buy;

        public ShopItemViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.nameProduct);
            txtDescription = (TextView) itemView.findViewById(R.id.descriptionProduct);
            image = (ImageView) itemView.findViewById(R.id.imageProduct);
            txtPrice = (TextView) itemView.findViewById(R.id.priceProduct);
            buy=(Button) itemView.findViewById(R.id.buyButton);
            buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name=txtName.getText().toString().toLowerCase();
                    int price=Integer.parseInt(txtPrice.getText().toString());
                    if (cash>=price){
                        Toast.makeText(v.getContext(),txtName.getText().toString()+ " purchased",Toast.LENGTH_SHORT).show();
                        Call<Inventory> inventoryCall =apiInterface.getInventory(id);
                        inventoryCall.enqueue(new Callback<Inventory>() {
                            @Override
                            public void onResponse(Call<Inventory> call, Response<Inventory> response) {
                                Log.d("TAG",response.code()+"");
                                if(response.code()==200){
                                    inventory=response.body();
                                    if (name.equals("turtle"))
                                    {
                                        int i= inventory.getTurtleQuantity();
                                        inventory.setTurtleQuantity(i+1);
                                    }
                                    if (name.equals("coffee"))
                                    {
                                        int i= inventory.getCoffQuantity();
                                        inventory.setCoffQuantity(i+1);
                                    }
                                    if (name.equals("redbull"))
                                    {
                                        int i= inventory.getRedbullQuantity();
                                        inventory.setRedbullQuantity(i+1);
                                    }
                                    if (name.equals("pills"))
                                    {
                                        int i= inventory.getPillsQuantity();
                                        inventory.setPillsQuantity(i+1);
                                    }
                                    if (name.equals("calculator"))
                                    {
                                        int i= inventory.getCalculatorQuantity();
                                        inventory.setCalculatorQuantity(i+1);
                                    }
                                    if (name.equals("rule"))
                                    {
                                        int i= inventory.getRuleQuantity();
                                        inventory.setRuleQuantity(i+1);
                                    }
                                    if (name.equals("compas"))
                                    {
                                        int i= inventory.getCompassQuantity();
                                        inventory.setCompassQuantity(i+1);
                                    }
                                    if (name.equals("pencil"))
                                    {
                                        int i= inventory.getPencilQuantity();
                                        inventory.setPencilQuantity(i+1);
                                    }
                                    if (name.equals("glasses"))
                                    {
                                        int i= inventory.getGlassesQuantity();
                                        inventory.setGlassesQuantity(i+1);
                                    }
                                    if (name.equals("puzzle"))
                                    {
                                        int i= inventory.getPuzzleQuantity();
                                        inventory.setPuzzleQuantity(i+1);
                                    }
                                    if (name.equals("book"))
                                    {
                                        int i= inventory.getBookQuantity();
                                        inventory.setBookQuantity(i+1);
                                    }
                                    if (name.equals("usb"))
                                    {
                                        int i= inventory.getUsbQuantity();
                                        inventory.setUsbQuantity(i+1);
                                    }
                                    if (name.equals("cheatsheet"))
                                    {
                                        int i= inventory.getCheatQuantity();
                                        inventory.setCheatQuantity(i+1);
                                    }
                                    Call<Inventory> inventory2Call =apiInterface.updateInventory(id,inventory);
                                    inventory2Call.enqueue(new Callback<Inventory>() {
                                        @Override
                                        public void onResponse(Call<Inventory> call, Response<Inventory> response) {
                                            Log.d("TAG",response.code()+"");
                                            if(response.code()==200){
                                                inventory=response.body();
                                            }
                                        }
                                        @Override
                                        public void onFailure(Call<Inventory> call, Throwable t) {
                                            call.cancel();
                                            Log.d("Error","Failure");
                                        }
                                    });


                                }
                            }
                            @Override
                            public void onFailure(Call<Inventory> call, Throwable t) {
                                call.cancel();
                                Log.d("Error","Failure");
                            }
                        });
                        int total=cash-price;
                        user.setCash(total);
                        Call<Usuario> userCall =apiInterface.updateCash(id,user);
                        userCall.enqueue(new Callback<Usuario>() {
                            @Override
                            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                                Log.d("TAG",response.code()+"");
                                if(response.code()==200){
                                    user=response.body();


                                }
                            }
                            @Override
                            public void onFailure(Call<Usuario> call, Throwable t) {
                                call.cancel();
                                Log.d("Error","Failure");
                            }
                        });
                    }
                    if(cash<=price){
                        Toast.makeText(v.getContext(),"Insufficient coins",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
