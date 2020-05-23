package com.example.eksamenS2.models;


enum Status {
    Ready,
    Cleaning,
    Repair,
    CleanAndRepair,
    Booked,
    OutOfOrder,
    TempBooked
}


public class MotorHome {

    private String NumberPlate, Models_Model_number;
    private int Total_Km, MotorHomesID;
    private Status status;


    public MotorHome() {
    }

    public MotorHome(String numberPlate, int total_Km, Status status) {
        NumberPlate = numberPlate;
        Total_Km = total_Km;
        this.status = status;
    }

    public MotorHome(int MotorHomesID, String numberPlate, String Models_Model_number, int total_Km, Status status) {
        NumberPlate = numberPlate;
        Total_Km = total_Km;
        this.status = status;
    }

    public String getModels_Model_number() {
        return Models_Model_number;
    }

    public void setModels_Model_number(String models_Model_number) {
        Models_Model_number = models_Model_number;
    }

    public int getMotorHomesID() {
        return MotorHomesID;
    }

    public void setMotorHomesID(int motorHomesID) {
        MotorHomesID = motorHomesID;
    }

    public int getTotal_Km() {
        return Total_Km;
    }

    public void setTotal_Km(int total_Km) {
        Total_Km = total_Km;
    }

    public String getStatus() {
        return this.status.name();
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        NumberPlate = numberPlate;
    }
}
