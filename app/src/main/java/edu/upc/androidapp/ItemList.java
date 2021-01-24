package edu.upc.androidapp;

import java.util.List;

public class ItemList {
    private int size;
    private List<Item> items;
    public List<Item> getItems(){return items;}
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItem(int index){
        return items.get(index);
    }

}
