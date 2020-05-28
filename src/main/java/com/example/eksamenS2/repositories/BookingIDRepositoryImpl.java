package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.BookingID;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingIDRepositoryImpl {
    private Connection conn;

    public BookingIDRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    public BookingID create(BookingID bookingID) {
        String sql = "INSERT INTO bookingid(FromDate,EndDate,CustomerID,Users_UserID) VALUES (?,?,?,?)";

        try {
            PreparedStatement createBookingID = conn.prepareStatement(sql);

            createBookingID.setDate(1, bookingID.getFromDate());
            createBookingID.setDate(2, bookingID.getEndDate());
            createBookingID.setInt(3, bookingID.getCustomerID());
            createBookingID.setString(4, bookingID.getStaffID());

            int rowsInserted = createBookingID.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("createBookingID er lavet");
            }
        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("BookingID create fejlet");

        }
        System.out.println("BookingID create Virket");
        return bookingID;
    }


}
