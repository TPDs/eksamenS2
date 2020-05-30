package com.example.eksamenS2.models;

import java.util.Date;

public class EndBooking {


    private int Endgas, EndKm, PickUpKm;
    private Date SeasonDate;


    public EndBooking(int endgas, int endKm, int pickUpKm, Date seasonDate) {
        Endgas = endgas;
        EndKm = endKm;
        PickUpKm = pickUpKm;
        SeasonDate = seasonDate;
    }


    public int getEndgas() {
        return Endgas;
    }

    public void setEndgas(int endgas) {
        Endgas = endgas;
    }

    public int getEndKm() {
        return EndKm;
    }

    public void setEndKm(int endKm) {
        EndKm = endKm;
    }

    public int getPickUpKm() {
        return PickUpKm;
    }

    public void setPickUpKm(int pickUpKm) {
        PickUpKm = pickUpKm;
    }

    public Date getSeasonDate() {
        return SeasonDate;
    }

    public void setSeasonDate(Date seasonDate) {
        SeasonDate = seasonDate;
    }


}