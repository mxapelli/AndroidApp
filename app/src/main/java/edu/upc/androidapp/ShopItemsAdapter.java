package edu.upc.androidapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopItemsAdapter extends RecyclerView.Adapter<ShopItemsAdapter.ShopItemViewHolder> {
    ArrayList<ShopItem> shopList;

    public ShopItemsAdapter(ArrayList<ShopItem> shopList){
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public ShopItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shop_list,null,false);
        return new ShopItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopItemViewHolder holder, int position) {
        holder.txtName.setText(shopList.get(position).getName());
        holder.txtDescription.setText(shopList.get(position).getDescription());
        holder.image.setImageResource(shopList.get(position).getImageId());
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public class ShopItemViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtDescription;
        ImageView image;

        public ShopItemViewHolder(View itemView){
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.nameProduct);
            txtDescription = (TextView) itemView.findViewById(R.id.descriptionProduct);
            image = (ImageView) itemView.findViewById(R.id.imageProduct);
        }
    }
}
