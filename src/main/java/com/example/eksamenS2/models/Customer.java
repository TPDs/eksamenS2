package com.example.eksamenS2.models;

public class Customer {

    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String Phone;
    private String DriverLicens;

    public Customer(){}

    public Customer(String firstName, String lastName, String email, String phone, String driverLicens) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Phone = phone;
        DriverLicens = driverLicens;
    }

    public Customer(int id,String firstName, String lastName, String email, String phone, String driverLicens) {
        ID = id;
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Phone = phone;
        DriverLicens = driverLicens;
    }

    public int getID() {
        return ID;
    }

    public void setID(int id) {
        this.ID = id;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getDriverLicens() {
        return DriverLicens;
    }

    public void setDriverLicens(String driverLicens) {
        DriverLicens = driverLicens;
    }
}
