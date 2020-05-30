package com.example.eksamenS2.models;

public class BookingAccItems {


    private int Amount, AccItemsID, BookingID;

    public BookingAccItems() {
    }

    public BookingAccItems(int amount, int accItemsID, int bookingID) {
        Amount = amount;
        AccItemsID = accItemsID;
        BookingID = bookingID;

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
