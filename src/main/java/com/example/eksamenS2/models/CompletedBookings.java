package com.example.eksamenS2.models;

import java.util.Date;


enum Season {
    Peak, Middle, Low

}


public class CompletedBookings {


    private int Start_Km, GasStatus, PickUpkm, days, End_Km, BookingID, MhId;
    private double MotorHomeprice;
    private Date FromDate, EndDate;
    private Season season;

    public CompletedBookings() {
    }

    public CompletedBookings(int startKm, int gasStatus, int pickUpkm, int days, int end_Km, int bookingID, int mhId, double motorHomeprice, Date fromDate, Date endDate) {
        Start_Km = startKm;
        GasStatus = gasStatus;
        PickUpkm = pickUpkm;
        this.days = days;
        End_Km = end_Km;
        BookingID = bookingID;
        MhId = mhId;
        MotorHomeprice = motorHomeprice;
        FromDate = fromDate;
        EndDate = endDate;
    }

    public CompletedBookings(int start_Km, int gasStatus, int pickUpkm, int days, int end_Km, int bookingID, int mhId, double motorHomeprice, Date fromDate, Date endDate, String season) {
        Start_Km = start_Km;
        GasStatus = gasStatus;
        PickUpkm = pickUpkm;
        this.days = days;
        End_Km = end_Km;
        BookingID = bookingID;
        MhId = mhId;
        MotorHomeprice = motorHomeprice;
        FromDate = fromDate;
        EndDate = endDate;
        setSeason(season);
    }


    public int getMhId() {
        return MhId;
    }

    public void setMhId(int mhId) {
        MhId = mhId;
    }

    public int getStart_Km() {
        return Start_Km;
    }

    public void setStart_Km(int start_Km) {
        Start_Km = start_Km;
    }

    public int getGasStatus() {
        return GasStatus;
    }

    public void setGasStatus(int endGas) {
        GasStatus = endGas;
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

    public void setSeason(String season) {
        this.season = Season.valueOf(season);
    }

    public String getSeason() {
        if (this.season != null) {

            return this.season.name();
        }
        return "Middle";
    }


    public int getEnd_Km() {
        return End_Km;
    }

    public void setEnd_Km(int end_Km) {
        End_Km = end_Km;
    }

    public int getBookingID() {
        return BookingID;
    }

    public void setBookingID(int bookingID) {
        BookingID = bookingID;
    }

    public double getMotorHomeprice() {
        return MotorHomeprice;
    }

    public void setMotorHomeprice(double motorHomeprice) {
        MotorHomeprice = motorHomeprice;
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
