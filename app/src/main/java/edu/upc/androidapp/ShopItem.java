package edu.upc.androidapp;

public class ShopItem {

    private String name;
    private String description;
    private int imageId;
    private String price;

    public ShopItem(String name, String description, int imageId, String price){
        this.name = name;
        this.description = description;
        this.imageId = imageId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
