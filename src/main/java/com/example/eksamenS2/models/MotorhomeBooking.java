package com.example.eksamenS2.models;

import java.util.Date;


//Lavet af Christian

public class MotorhomeBooking {

    private int motorhomeID, bookingID;
    private Date start, end;

    public MotorhomeBooking() {
    }

    public MotorhomeBooking(int motorhomeID, int bookingID) {
        this.motorhomeID = motorhomeID;
        this.bookingID = bookingID;
    }

    public MotorhomeBooking(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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
