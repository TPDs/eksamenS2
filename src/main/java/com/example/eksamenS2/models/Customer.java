package com.example.eksamenS2.models;

public class Customer {

    private String FirstName;
    private String LastName;
    private String Email;
    private int Phone;
    private String DriverLicens;


    public Customer(String firstName, String lastName, String email, int phone, String driverLicens) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        Phone = phone;
        DriverLicens = driverLicens;
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

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getDriverLicens() {
        return DriverLicens;
    }

    public void setDriverLicens(String driverLicens) {
        DriverLicens = driverLicens;
    }
}
