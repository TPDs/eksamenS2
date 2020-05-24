package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.AccItems;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccItemsRepository {
    private Connection conn;
    public AccItemsRepository() {this.conn = DatabaseConnectionManager.getDatabaseConnection();}


    public boolean create(AccItems accItems){
        String sql = "INSERT INTO acc.items(ItemsID, Name, Price) VALUES (?, ?, ?)";

        try {
            PreparedStatement psItems = conn.prepareStatement(sql);

            psItems.setInt(1, accItems.getItemsID());
            psItems.setString(1, accItems.getName());
            psItems.setInt(1, accItems.getPrice());

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


    public AccItems read(int id){
        AccItems accItemsToReturn = new AccItems();

        try {
            PreparedStatement getSingleAccItem = conn.prepareStatement("SELECT * FROM acc.items WHERE id=" +id);
            ResultSet rs = getSingleAccItem.executeQuery();

            while(rs.next()){
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

    public List<AccItems> readAll(){
        List<AccItems> allAccItems = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM acc.items");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AccItems tempAccItem = new AccItems();
                tempAccItem.setItemsID(rs.getInt(1));
                tempAccItem.setName(rs.getString(2));
                tempAccItem.setPrice(rs.getInt(3));
                allAccItems.add(tempAccItem);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("noget gik galt da man forsøgte at bruge read all metoden");
        }
        System.out.println("alting gik fint med readallAcc metoden");
        return allAccItems;
    }

    public boolean update(AccItems accItems){
        String sql = "UPDATE acc.items SET ItemsID=?, Name=?, Price=? WHERE id="+ accItems.getItemsID();

        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,accItems.getItemsID());
            ps.setString(2,accItems.getName());
            ps.setInt(3,accItems.getPrice());

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

    public boolean delete(int id){
        String sql = "DELETE FROM acc.items WHERE id=?";

        try {
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1, id);

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