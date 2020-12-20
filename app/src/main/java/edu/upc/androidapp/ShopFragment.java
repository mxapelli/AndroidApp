package edu.upc.androidapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopFragment extends Fragment {
    RecyclerView recyclerShop;
    ArrayList<ShopItem> shopList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_shop, container,false);
        shopList = new ArrayList<>();
        recyclerShop = vista.findViewById(R.id.recyclerShop);
        recyclerShop.setLayoutManager(new LinearLayoutManager(getContext()));

        llenarLista();

        ShopItemsAdapter adapter = new ShopItemsAdapter(shopList);
        recyclerShop.setAdapter(adapter);
        return vista;
    }

    private void llenarLista() {
        shopList.add(new ShopItem("Calculadora","Información de la calculadora", R.mipmap.ic_calculadora_icon));
        shopList.add(new ShopItem("Lapiz","Información del Lapiz", R.mipmap.ic_calculadora_icon));
        shopList.add(new ShopItem("Gafas","Información de las Gafas", R.mipmap.ic_calculadora_icon));
        shopList.add(new ShopItem("Red Bull","Información de Red Bull", R.mipmap.ic_calculadora_icon));
    }
}
