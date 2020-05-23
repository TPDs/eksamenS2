package com.example.eksamenS2.models;

public class AccItems {


    private String Name;
    private int Price;

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

    public AccItems(String name, int price) {
        Name = name;
        Price = price;
    }
}
