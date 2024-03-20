package com.slmcrptbrs.crptoborsa.dao;


import com.slmcrptbrs.crptoborsa.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private List<User> users;

    @Override
    public List<User> getAllUsers() {

        users = new ArrayList<>();
        try {
            Connection conn = ConnectionManager.getConnection();
            String q = "select * from users";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);

            while (rs.next()) {
                User u = new User(rs.getString("name"), rs.getString("surname"), rs.getString("email"), rs.getString("password"));
                users.add(u);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return users;
    }

    @Override
    public boolean addUser(User user) {

        try {

            Connection conn = ConnectionManager.getConnection();
            String q = "INSERT INTO users ( name, surname, email, password) VALUES(?,?,?,?)";

            PreparedStatement psmt = conn.prepareStatement(q);
            psmt.setString(1, user.getName());
            psmt.setString(2, user.getSurname());
            psmt.setString(3, user.getEmail());
            psmt.setString(4, user.getPassword());

            psmt.executeUpdate();

            return true;
        } catch (Exception e){
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean deleteUser(User user) {



        PreparedStatement psmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            String q = "DELETE FROM users WHERE email=? and password=?";

            psmt = conn.prepareStatement(q);
            psmt.setString(1, user.getEmail());
            psmt.setString(2, user.getPassword());
            psmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }

    }

    @Override
    public boolean isRegistered(User user) {


        PreparedStatement psmt = null;
        try {
            Connection conn = ConnectionManager.getConnection();
            String q = "SELECT * FROM users WHERE email=? and password=?";
            psmt = conn.prepareStatement(q);
            psmt.setString(1, user.getEmail());
            psmt.setString(2, user.getPassword());

            ResultSet rs = psmt.executeQuery();

            if(rs.next()) {
                return true;

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return false;
    }
}

