package com.example.eksamenS2.models;


enum Status {Ready, Cleaning, Repair, CleanAndRepair, Booked, OutOfOrder, TempBooked}


public class MotorHome {

    private int Total_Km;
    private Status status;


    public MotorHome(int total_Km, Status status) {
        Total_Km = total_Km;
        this.status = status;
    }

    public int getTotal_Km() {
        return Total_Km;
    }

    public void setTotal_Km(int total_Km) {
        Total_Km = total_Km;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
