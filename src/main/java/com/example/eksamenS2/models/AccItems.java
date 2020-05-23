package com.example.eksamenS2.models;

public class AccItems {

    private int ItemsID;
    private String Name;
    private int Price;

    public AccItems(){}

    public AccItems(int itemsID, String name, int price) {
        ItemsID = itemsID;
        Name = name;
        Price = price;
    }

    public AccItems(String name, int price) {
        Name = name;
        Price = price;
    }

    public int getItemsID() { return ItemsID; }

    public void setItemsID(int itemsID) { ItemsID = itemsID; }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

}
