package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.MotorHome;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MotorHomeRepositoryImpl implements IMotorHomeRepository {
    private Connection conn;

    public MotorHomeRepositoryImpl() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }


    @Override
    public boolean create(MotorHome MotorHome) {
        // MotorHome motorHomeToCreate = new MotorHome();
        String sql = "INSERT INTO motorhomes(NumberPlate, Models_Model_number, Total_Km, Status) VALUES (?,?,?,?)";
        try {
            PreparedStatement motorHomeToCreate = conn.prepareStatement(sql);
            motorHomeToCreate.setString(1, MotorHome.getNumberPlate());
            motorHomeToCreate.setString(2, MotorHome.getModels_Model_number());
            motorHomeToCreate.setInt(3, MotorHome.getTotal_Km());
            motorHomeToCreate.setString(4, MotorHome.getStatus());
            int rowsInserted = motorHomeToCreate.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Successfully!");
            }

            return true;
        } catch (
                SQLException s) {
            s.printStackTrace();
            System.out.println("Fejlet");
        }
        return false;
    }


    @Override
    public MotorHome read(int id) {
        MotorHome MotorHomeToReturn = new MotorHome();
        try {
            PreparedStatement getSingleMotorHome = conn.prepareStatement("SELECT * FROM motorhomes WHERE MotorHomesID=" + id);
            ResultSet rs = getSingleMotorHome.executeQuery();
            while (rs.next()) {
                MotorHomeToReturn.setMotorHomesID(rs.getInt(1));
                MotorHomeToReturn.setNumberPlate(rs.getString(2));
                MotorHomeToReturn.setModels_Model_number(rs.getString(3));
                MotorHomeToReturn.setTotal_Km(rs.getInt(4));
                MotorHomeToReturn.setStatus(rs.getString(5));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }

        return MotorHomeToReturn;
    }


    @Override
    public List<MotorHome> readAll() {
        List<MotorHome> AllMotorHome = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM motorhomes");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MotorHome tempMotorHome = new MotorHome();
                tempMotorHome.setMotorHomesID(rs.getInt(1));
                tempMotorHome.setNumberPlate(rs.getString(2));
                tempMotorHome.setModels_Model_number(rs.getString(3));
                tempMotorHome.setTotal_Km(rs.getInt(4));
                tempMotorHome.setStatus(rs.getString(5));
                AllMotorHome.add(tempMotorHome);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return AllMotorHome;
    }

    @Override
    public boolean update(MotorHome motorHome) {
        String sql = "UPDATE motorhomes SET NumberPlate=?, Models_Model_number=?, Total_Km=?, Status=? WHERE MotorHomesID=" + motorHome.getMotorHomesID();

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, motorHome.getNumberPlate());
            statement.setString(2, motorHome.getModels_Model_number());
            statement.setInt(3,motorHome.getTotal_Km());
            statement.setString(4, motorHome.getStatus());

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("An existing motorhome was updated successfully!");
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }


    public boolean updateStatus(MotorHome motorHome){
        String sql = "UPDATE motorhomes SET Status=? WHERE MotorHomesID=" + motorHome.getMotorHomesID();

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, motorHome.getStatus());

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0){
                System.out.println("An existing motorhome was updated successfully!");
            }

        } catch (SQLException throwables){
            throwables.printStackTrace();
            System.out.printf("Pernis");
        }
        return false;
    }
}




