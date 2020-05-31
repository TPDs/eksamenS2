package com.example.eksamenS2.models;

public class TypesByModel {

   private String typer;
   private String status;
   private int Ready, Cleaning, Repair, CleanAndRepair, Booked, OutOfOrder, TempBooked;

    public TypesByModel(String typer, String status) {
        this.typer = typer;
        this.status = status;
    }

    public TypesByModel()
    {
        status = "";
    }

    public TypesByModel(String typer, int ready, int cleaning, int repair, int cleanAndRepair, int booked, int outOfOrder, int tempBooked) {
        this.typer = typer;
        Ready = ready;
        Cleaning = cleaning;
        Repair = repair;
        CleanAndRepair = cleanAndRepair;
        Booked = booked;
        OutOfOrder = outOfOrder;
        TempBooked = tempBooked;
    }

    public int getReady() {
        return Ready;
    }

    public void setReady(int ready) {
        Ready = ready;
    }

    public int getCleaning() {
        return Cleaning;
    }

    public void setCleaning(int cleaning) {
        Cleaning = cleaning;
    }

    public int getRepair() {
        return Repair;
    }

    public void setRepair(int repair) {
        Repair = repair;
    }

    public int getCleanAndRepair() {
        return CleanAndRepair;
    }

    public void setCleanAndRepair(int cleanAndRepair) {
        CleanAndRepair = cleanAndRepair;
    }

    public int getBooked() {
        return Booked;
    }

    public void setBooked(int booked) {
        Booked = booked;
    }

    public int getOutOfOrder() {
        return OutOfOrder;
    }

    public void setOutOfOrder(int outOfOrder) {
        OutOfOrder = outOfOrder;
    }

    public int getTempBooked() {
        return TempBooked;
    }

    public void setTempBooked(int tempBooked) {
        TempBooked = tempBooked;
    }

    public String getTyper() {
        return typer;
    }

    public void setTyper(String typer) {
        this.typer = typer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
