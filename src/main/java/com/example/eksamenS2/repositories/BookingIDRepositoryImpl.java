package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.BookingID;
import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

        return bookingID;
    }


    public List<MotorHome> readAllbyModel(String modelID) {
        List<MotorHome> AllMotorHomesByModel = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM motorhomes WHERE Models_Model_number=" + modelID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MotorHome tempMotorHomeByModel = new MotorHome();
                tempMotorHomeByModel.setMotorHomesID(rs.getInt(1));
                tempMotorHomeByModel.setNumberPlate(rs.getString(2));
                tempMotorHomeByModel.setModels_Model_number(rs.getString(3));
                tempMotorHomeByModel.setTotal_Km(rs.getInt(4));
                tempMotorHomeByModel.setStatus(rs.getString(5));
                AllMotorHomesByModel.add(tempMotorHomeByModel);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AllMotorHomesByModel;
    }
}
