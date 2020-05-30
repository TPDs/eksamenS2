package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.MotorhomeBooking;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MotorhomeBookingRepository {
    private Connection conn;
    public MotorhomeBookingRepository() {this.conn= DatabaseConnectionManager.getDatabaseConnection(); }


    public List<MotorhomeBooking> showCurrentBookings(){
        List<MotorhomeBooking> AllBookingsMHB = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM motorhome_booking");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MotorhomeBooking tempMotorhomeBooking = new MotorhomeBooking();
                tempMotorhomeBooking.setMotorhomeID(rs.getInt(1));
                tempMotorhomeBooking.setBookingID(rs.getInt(2));
                AllBookingsMHB.add(tempMotorhomeBooking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AllBookingsMHB;
    }





}
