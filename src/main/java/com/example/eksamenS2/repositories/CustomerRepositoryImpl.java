package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.Customer;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl {
    private Connection conn;

    public CustomerRepositoryImpl() { this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    public boolean create(Customer customer) {
        String sql = "INSERT INTO customer(FirstName, LastName, Email, Phone, DriverLicens) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement createCustomer = conn.prepareStatement(sql);

            createCustomer.setString(1, customer.getFirstName());
            createCustomer.setString(1, customer.getLastName());
            createCustomer.setString(1, customer.getEmail());
            createCustomer.setInt(1, customer.getPhone());
            createCustomer.setString(1,customer.getDriverLicens());

            int rowsInserted = createCustomer.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("En kunde er blevet oprettet Successfully!");
            }
            return true;

        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("Oprettelse af kunde har Fejlet");
        }
        return false;
    }


    public Customer read(int id) {
        Customer customerToReturn = new Customer();

        try {
            PreparedStatement getSingleCustomer = conn.prepareStatement("SELECT * FROM customer WHERE id=" + id);
            ResultSet rs = getSingleCustomer.executeQuery();

            while(rs.next()) {
                customerToReturn.setID(rs.getInt(1));
                customerToReturn.setFirstName(rs.getString(2));
                customerToReturn.setLastName(rs.getString(3));
                customerToReturn.setEmail(rs.getString(4));
                customerToReturn.setPhone(rs.getInt(5));
                customerToReturn.setDriverLicens(rs.getString(6));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return customerToReturn;
    }


    public List<Customer> readAll() {

        List<Customer> allCustomers = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Customer tempCustomer = new Customer();
                tempCustomer.setID(rs.getInt(1));
                tempCustomer.setFirstName(rs.getString(2));
                tempCustomer.setLastName(rs.getString(3));
                tempCustomer.setEmail(rs.getString(4));
                tempCustomer.setPhone(rs.getInt(5));
                tempCustomer.setDriverLicens(rs.getString(5));
                allCustomers.add(tempCustomer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allCustomers;
    }


    public boolean update(Customer customer) {
        String sql = "UPDATE customer SET ID=?, FirstName=?, LastName=?, Email=?, Phone=?, DriverLicens=?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, customer.getID());
            statement.setString(2, customer.getFirstName());
            statement.setString(3, customer.getLastName());
            statement.setString(4, customer.getEmail());
            statement.setInt(5, customer.getPhone());
            statement.setString(6, customer.getDriverLicens());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("En existerende kunde blev updateret i Systemet!successfully!!");
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Systemet havde en fejl da en Kunde prøves updateret!");
        }
        return false;
    }


    public boolean delete(int id) {

        String sql = "DELETE FROM customer WHERE id=?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("en kunde blev slettet successfully!");
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("en kunde blev ikke slettet og noget gik galt");
        }
        return false;
    }
}
