package com.example.eksamenS2.models;

public class CancelBooking {


    private java.sql.Date Fromdate, EndDate;
    private int CustomerID, MotorHomes_MotorHomesID, Price;
    private String Models_Model_number, FirstName, LastName, Users_UserID, Email, phone;

    public CancelBooking() {
    }

    public String getUsers_UserID() {
        return Users_UserID;
    }

    public void setUsers_UserID(String users_UserID) {
        Users_UserID = users_UserID;
    }

    public CancelBooking(java.sql.Date fromdate, java.sql.Date endDate, int customerID, int motorHomes_MotorHomesID, int price, String models_Model_number, String firstName, String lastName, String users_UserID, String email, String phone) {
        Fromdate = fromdate;
        EndDate = endDate;
        CustomerID = customerID;
        MotorHomes_MotorHomesID = motorHomes_MotorHomesID;
        Price = price;
        Models_Model_number = models_Model_number;
        FirstName = firstName;
        LastName = lastName;
        Users_UserID = users_UserID;
        Email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public java.sql.Date getFromdate() {
        return Fromdate;
    }

    public void setFromdate(java.sql.Date fromdate) {
        Fromdate = fromdate;
    }

    public java.sql.Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(java.sql.Date endDate) {
        EndDate = endDate;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public int getMotorHomes_MotorHomesID() {
        return MotorHomes_MotorHomesID;
    }

    public void setMotorHomes_MotorHomesID(int motorHomes_MotorHomesID) {
        MotorHomes_MotorHomesID = motorHomes_MotorHomesID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getModels_Model_number() {
        return Models_Model_number;
    }

    public void setModels_Model_number(String models_Model_number) {
        Models_Model_number = models_Model_number;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}
