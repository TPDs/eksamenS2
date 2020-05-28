package com.example.eksamenS2.repositories;

import com.example.eksamenS2.models.Users;
import com.example.eksamenS2.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository {
    private Connection conn;

    public UsersRepository() {
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    public Users read(Users users) {
        Users UsersToReturn = new Users();
        System.out.println(users.getUserID() + " " + users.getPassword());
        try {
            String sql = "SELECT * FROM users WHERE UserID= ? AND Password= ?";
            PreparedStatement rs = conn.prepareStatement(sql);
            rs.setString(1, users.getUserID());
            rs.setString(2, users.getPassword());

            ResultSet ps = rs.executeQuery();
            if (ps.next()) {
                UsersToReturn.setUserID(ps.getString(1));
                UsersToReturn.setFirstName(ps.getString(2));
                UsersToReturn.setLastName(ps.getString(3));
                //UsersToReturn.setPassword(ps.getString(4));
                UsersToReturn.setRole(ps.getString(5));
                System.out.println("Det virker");
            }
        } catch (SQLException s) {
            s.printStackTrace();
            System.out.println("Der er en fejl");
        }
        return UsersToReturn;
    }
}
