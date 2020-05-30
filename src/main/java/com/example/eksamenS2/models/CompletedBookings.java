package com.example.eksamenS2.models;

import java.util.Date;

public class CompletedBookings {


    private int Total_km, EndGas, PickUpkm, days, Kmperday, BookingID, MhId;
    private double SeasonPrice;
    private Date FromDate, EndDate;

    public CompletedBookings(int total_km, int endGas, int pickUpkm, int days, int kmperday, int bookingID, int MhId, double seasonPrice, Date fromDate, Date endDate) {
        Total_km = total_km;
        EndGas = endGas;
        PickUpkm = pickUpkm;
        this.days = days;
        Kmperday = kmperday;
        BookingID = bookingID;
        SeasonPrice = seasonPrice;
        FromDate = fromDate;
        EndDate = endDate;
        this.MhId = MhId;
    }

    public int getMhId() {
        return MhId;
    }

    public void setMhId(int mhId) {
        MhId = mhId;
    }

    public int getTotal_km() {
        return Total_km;
    }

    public void setTotal_km(int total_km) {
        Total_km = total_km;
    }

    public int getEndGas() {
        return EndGas;
    }

    public void setEndGas(int endGas) {
        EndGas = endGas;
    }

    public int getPickUpkm() {
        return PickUpkm;
    }

    public void setPickUpkm(int pickUpkm) {
        PickUpkm = pickUpkm;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getKmperday() {
        return Kmperday;
    }

    public void setKmperday(int kmperday) {
        Kmperday = kmperday;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public double getSeasonPrice() {
        return SeasonPrice;
    }

    public void setSeasonPrice(double seasonPrice) {
        SeasonPrice = seasonPrice;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }


}
