package com.example.eksamenS2.models;

public class MotorhomeBooking {

    private int motorhomeID, bookingID;

    public MotorhomeBooking(){}

    public MotorhomeBooking(int motorhomeID, int bookingID){
        this.motorhomeID = motorhomeID;
        this.bookingID = bookingID;
    }

    public int getMotorhomeID() {
        return motorhomeID;
    }

    public void setMotorhomeID(int motorhomeID) {
        this.motorhomeID = motorhomeID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }
}
