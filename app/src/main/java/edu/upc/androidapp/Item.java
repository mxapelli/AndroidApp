package edu.upc.androidapp;

public class Item {
    private String name;
    private String description;
    private int price;
    private String image;
    private String ID;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Item(String name, String description, int price, String image, String ID) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.ID = ID;
    }
    public Item(){

    }
}
