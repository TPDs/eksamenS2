package com.example.eksamenS2.models;


enum Role {
    Staff, Mecanic, Sales, BookKeeper, Manager

}

public class Users {

    private String UserID, FirstName, LastName, Password;
    public Role role;

    public Users() {
    }


    public Users(String firstName, String lastName, String password, Role role) {
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        this.role = role;
    }

    public Users(String userID, String firstName, String lastName, String password, Role role) {
        UserID = userID;
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        this.role = role;
    }

    public Users(String userID, String password) {
        UserID = userID;
        Password = password;
    }


    public String getUserID() {
        return UserID;
    }

    public Users(String firstName, Role role) {
        FirstName = firstName;
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

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    @Override
    public String toString() {
        return " " + role;
    }
}
