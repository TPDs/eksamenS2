package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.Models;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelRepository {
    private Connection conn;
    public ModelRepository() {this.conn= DatabaseConnectionManager.getDatabaseConnection(); }


    // skal lave en metode der kan iterere igennem model numre til visning på "opret motorhome" siden
public String saveIteratedModelNr(int indexPos)
{
    ArrayList<String> ModelNrTemp = new ArrayList<>();
    try {
        PreparedStatement ModelPs= conn.prepareStatement("SELECT * FROM models");
        ResultSet rs = ModelPs.executeQuery();
        int i =1;
        while(rs.next()){

            if(i == indexPos){
                ModelNrTemp.add(rs.getString(1));
            }
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return "" + ModelNrTemp.get(0);
}

    public boolean create(Models model){
        String sql = "INSERT INTO models(Model_number, Brand, Type, Engine, About, Length, GearType, Aircon, Km_L, year, Price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            // mangler muligvis nogle ændringer i isGearType og isAircon så der gives nogle værdier
            //istedet for boolean da SQL tager 0 og 1 som boolean inputs.
            ps.setString(1,model.getModel_number());
            ps.setString(2,model.getBrand());
            ps.setString(3,model.getType());
            ps.setDouble(6,model.getLength());
            ps.setInt(9,model.getKm_L());
            ps.setInt(10,model.getYear());
            ps.setBoolean(7,model.isGearType());
            ps.setString(4,model.getEngine());
            ps.setBoolean(8, model.isAircon());
            ps.setString(5,model.getAbout());
            ps.setInt(11,model.getPrice());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Der blev oprettet en ny model i databasen " + "Successfully!");
                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("something is a mess ved oprettelse af model");
        }
        return false;
    }


    public Models read(String Model_number){
        Models modelToReturn = new Models();
        try {
            PreparedStatement getSingleModel = conn.prepareStatement("SELECT * FROM models WHERE Model_number='" + Model_number+"'");
            ResultSet rs = getSingleModel.executeQuery();
            while(rs.next()){
                modelToReturn.setModel_number(rs.getString(1));
                modelToReturn.setBrand(rs.getString(2));
                modelToReturn.setType(rs.getString(3));
                modelToReturn.setLength(rs.getDouble(4));
                modelToReturn.setKm_L(rs.getInt(5));
                modelToReturn.setYear(rs.getInt(6));
                modelToReturn.setGearType(rs.getBoolean(7));
                modelToReturn.setEngine(rs.getString(8));
                modelToReturn.setAircon(rs.getBoolean(9));
                modelToReturn.setAbout(rs.getString(10));
                modelToReturn.setPrice(rs.getInt(11));

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("oh noes read models no worki");
        }
        return modelToReturn;
    }


    public List<Models> readAll() {
        List<Models> allModels = new ArrayList<>();
        try {
            PreparedStatement ps= conn.prepareStatement("SELECT * FROM models");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Models tempModel = new Models();
                tempModel.setModel_number(rs.getString(1));
                tempModel.setBrand(rs.getString(2));
                tempModel.setType(rs.getString(3));
                tempModel.setLength(rs.getDouble(4));
                tempModel.setKm_L(rs.getInt(5));
                tempModel.setYear(rs.getInt(6));
                tempModel.setGearType(rs.getBoolean(7));
                tempModel.setEngine(rs.getString(8));
                tempModel.setAircon(rs.getBoolean(9));
                tempModel.setAbout(rs.getString(10));
                tempModel.setPrice(rs.getInt(11));
                allModels.add(tempModel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ohnoes Readyall Models");
        }
        System.out.println("Read all Model virker");
        return allModels;
    }


    public boolean update(Models model) {
        String sql = "UPDATE models SET Model_number=?, Brand=?, Type=?, Length=?, Km_L=?, Year=?, GearType=?, Engine=?, Aircon=?, About=?, Price=? WHERE Model_number='" + model.getModel_number()+"'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,model.getModel_number());
            ps.setString(2,model.getBrand());
            ps.setString(3,model.getType());
            ps.setDouble(4,model.getLength());
            ps.setInt(5,model.getKm_L());
            ps.setInt(6,model.getYear());
            ps.setBoolean(7,model.isGearType());
            ps.setString(8,model.getEngine());
            ps.setBoolean(9,model.isAircon());
            ps.setString(10,model.getAbout());
            ps.setInt(11,model.getPrice());

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("En model blev updateret successfullllllly!!");
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("huston. we have a problem models update metode");
        }
        return false;
    }


    public boolean delete(String Model_number){

        String sql = "DELETE FROM models WHERE Model_number=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,Model_number);

            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("en model blev sletetetet korrekto!");
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("noget gik galt med metodekalder Delete models! ohoh");
        }
        return false;
    }
}
