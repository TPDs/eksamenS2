package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.BookingID;
import com.example.eksamenS2.models.CancelBooking;
import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.models.MotorhomeBooking;
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

    //Lavet af Christian

    public List<BookingID> showCurrentBookings() {
        List<BookingID> AllBookingsBK = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM bookingid");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookingID tempBookingID = new BookingID();
                tempBookingID.setBookingID(rs.getInt(1));
                tempBookingID.setFromDate(rs.getDate(2));
                tempBookingID.setEndDate(rs.getDate(3));
                tempBookingID.setCustomerID(rs.getInt(4));
                tempBookingID.setStaffID(rs.getString(5));
                AllBookingsBK.add(tempBookingID);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AllBookingsBK;
    }


    //Lavet af Christian

    public List<MotorhomeBooking> AllBookingsbyMotorHome(int motorHome) {
        List<MotorhomeBooking> AllBookingsByMotorhome = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM motorhome_booking WHERE MotorHomes_MotorHomesID=" + motorHome);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MotorhomeBooking tempBooking = new MotorhomeBooking();
                tempBooking.setBookingID(rs.getInt(2));
                AllBookingsByMotorhome.add(tempBooking);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return AllBookingsByMotorhome;
    }


    public BookingID BookingIdByInt(int id) {
        BookingID bookingID = new BookingID();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM bookingid WHERE BookingID=" + id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                bookingID.setBookingID(rs.getInt(1));
                bookingID.setFromDate(rs.getDate(2));
                bookingID.setEndDate(rs.getDate(3));
                bookingID.setCustomerID(rs.getInt(4));
                bookingID.setStaffID(rs.getString(5));

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return bookingID;
    }


    public int MotorhomeByBookingID(int id) {
        int MotorHomeid = 1;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM motorhome_booking WHERE Booking_Id_BookingID=" + id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MotorHomeid = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        System.out.println("test");
        return MotorHomeid;
    }

    //Lavet af Christian

    public boolean deleteBooking(BookingID bookingID) {

        String sql = "DELETE FROM bookingid WHERE BookingID=?";

        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, bookingID.getBookingID());

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("En booking er herved blevet slettet! Hahah!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return false;
    }


    public CancelBooking cencelBooking(int id) {
        CancelBooking cancelBooking = new CancelBooking();

        String sql = "SELECT FromDate,EndDate,CustomerID,FirstName,LastName, Users_UserID,Email,Phone, MotorHomes_MotorHomesID,Models_Model_number,Price " +
                "FROM bookingid " +
                "INNER JOIN customer USING (CustomerID) " +
                "INNER Join motorhome_booking on Booking_Id_BookingID=BookingID " +
                "INNER Join motorhomes on MotorHomes_MotorHomesID= MotorHomesID " +
                "INNER Join models on Models_Model_number= Model_number " +
                "WHERE BookingID='" + id + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                cancelBooking.setFromdate(rs.getDate(1));
                cancelBooking.setEndDate(rs.getDate(2));
                cancelBooking.setCustomerID(rs.getInt(3));
                cancelBooking.setFirstName(rs.getString(4));
                cancelBooking.setLastName(rs.getString(5));
                cancelBooking.setUsers_UserID(rs.getString(6));
                cancelBooking.setEmail(rs.getString(7));
                cancelBooking.setPhone(rs.getString(8));
                cancelBooking.setMotorHomes_MotorHomesID(rs.getInt(9));
                cancelBooking.setModels_Model_number(rs.getString(10));
                cancelBooking.setPrice(rs.getInt(11));


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return cancelBooking;
    }


}
