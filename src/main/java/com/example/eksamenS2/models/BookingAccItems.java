package com.example.eksamenS2.models;

public class BookingAccItems {


    private int Amount, AccItemsID, BookingID, ItemID, Price;
    private String Name;

    public BookingAccItems() {
    }

    public BookingAccItems(int amount, int accItemsID, int bookingID) {
        Amount = amount;
        AccItemsID = accItemsID;
        BookingID = bookingID;

    }


    public BookingAccItems(int amount, int accItemsID, int bookingID, int itemID, int price, String name) {
        Amount = amount;
        AccItemsID = accItemsID;
        BookingID = bookingID;
        ItemID = itemID;
        Price = price;
        Name = name;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public int getAccItemsID() {
        return AccItemsID;
    }

    public void setAccItemsID(int accItemsID) {
        AccItemsID = accItemsID;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }
}
