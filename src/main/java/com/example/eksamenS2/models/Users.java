package com.example.eksamenS2.models;


enum Role {
    Staff, Mecanic, Sales, BookKeeper, Manager

}

public class Users {

    private String FirstName, LastName, Password;
    private Role role;

    public Users(String firstName, String lastName, String password, Role role) {
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        this.role = role;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
