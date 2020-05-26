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

        try {
            String sql = "SELECT * FROM users WHERE UserID=" + users.getUserID() + "and Password=" + users.getPassword();
            PreparedStatement rs = conn.prepareStatement(sql);
            ResultSet ps = rs.executeQuery();


        } catch (SQLException s) {
            s.printStackTrace();
        }
        return UsersToReturn;
    }
}
