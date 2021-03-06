package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.AccItems;
import com.example.eksamenS2.models.BookingAccItems;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccItemsRepository {
    private Connection conn;
    // Lavet af Daniel P
    public AccItemsRepository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    // AutoIncrement skal ikke have input data ved oprettelse, den bliver oprettet automatisk
//INSERT INTO Persons (FirstName,LastName)
//VALUES ('Lars','Monsen');
//Disse vil autogenerere en primary key med Auto Increment værdi "starter på 1 som default"
// jeg har outcommentet ændringen så det kan bruges som eksempel
    public boolean create(AccItems accItems) {
        String sql = "INSERT INTO accitems(/*ItemsID,*/ Name, Price) VALUES (/*?,*/ ?, ?)";

        try {
            PreparedStatement psItems = conn.prepareStatement(sql);

            // psItems.setInt(1, accItems.getItemsID());
            psItems.setString(1, accItems.getName());
            psItems.setInt(2, accItems.getPrice());

            int rowsInserted = psItems.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Acc item blev oprettet Successfully!");
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("der skete en fejl ved oprettelse af Acc item");
        }
        return false;
    }


    public AccItems read(int ItemsID) {
        AccItems accItemsToReturn = new AccItems();

        try {
            PreparedStatement getSingleAccItem = conn.prepareStatement("SELECT * FROM accitems WHERE ItemsID=" + ItemsID);
            ResultSet rs = getSingleAccItem.executeQuery();

            while (rs.next()) {
                accItemsToReturn = new AccItems();

                accItemsToReturn.setItemsID(rs.getInt(1));
                accItemsToReturn.setName(rs.getString(2));
                accItemsToReturn.setPrice(rs.getInt(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("noget gik galt da accItems read metode skulle finde data i Databasen");
        }
        System.out.println("Databasen's data fungerede fint med read metoden");
        return accItemsToReturn;
    }

    public List<AccItems> readAll() {
        List<AccItems> allAccItems = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM accitems");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AccItems tempAccItem = new AccItems();
                tempAccItem.setItemsID(rs.getInt(1));
                tempAccItem.setName(rs.getString(2));
                tempAccItem.setPrice(rs.getInt(3));
                allAccItems.add(tempAccItem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }

        return allAccItems;
    }

// MP
    public List<BookingAccItems> readAllByBooking(int id) {
        List<BookingAccItems> allAccItemsByBooking = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT ItemsID,Name,Price,amount FROM accitems INNER Join booking_accitems ON ItemsID = AccItems_ItemsID WHERE BookingId_BookingID =" + id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookingAccItems tempAccItem = new BookingAccItems();
                tempAccItem.setPrice(rs.getInt(3));
                tempAccItem.setAccItemsID(rs.getInt(1));
                tempAccItem.setName(rs.getString(2));
                tempAccItem.setAmount(rs.getInt(4));
                allAccItemsByBooking.add(tempAccItem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allAccItemsByBooking;
    }

    // DP, bruges ikke i denne iteration
    public boolean update(AccItems accItems) {
        String sql = "UPDATE accitems SET Name=?, Price=? WHERE ItemsID=" + accItems.getItemsID();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setInt(1,accItems.getItemsID());
            ps.setString(1, accItems.getName());
            ps.setInt(2, accItems.getPrice());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("En existerende Acc item blev updateret successfully!!");
            }
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("noget gik galt da vi prøvede at updatere et Acc item");
        }
        return false;
    }

    public boolean delete(int ItemsID) {
        String sql = "DELETE FROM accitems WHERE ItemsID=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ItemsID);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Et AccItem blev slettet successfully!");
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("noget gik galt da vi prøvede at slette en AccItem");
        }
        return false;
    }
}
