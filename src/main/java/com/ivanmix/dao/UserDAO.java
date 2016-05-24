package com.ivanmix.dao;


import com.ivanmix.configuration.ConnectionPool;
import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

/**
 * Created by ivan on 23.05.2016.
 */
public class UserDAO {

    public void add(User user){
        try {
            Connection connection = ConnectionPool.connection().getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into client values (nextval('client_seq'),?,?,?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User get(String id){
        String userId = "";
        String userLogin = "";
        String userPassword = "";
        String userRole = "";
        try {
            Connection connection = ConnectionPool.connection().getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM client WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userId = rs.getString("id");
                userLogin = rs.getString("login");
                userPassword = rs.getString("password");
                userRole = rs.getString("role");
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User(userId,userLogin,userPassword,new Role(userRole));
        return user;
    }

    public User getUser(String login){

        String userId = "";
        String userLogin = "";
        String userPassword = "";
        String userRole = "";

        try {


            Connection connection = ConnectionPool.connection().getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM client WHERE login = ?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                userId = rs.getString("id");
                userLogin = rs.getString("login");
                userPassword = rs.getString("password");
                userRole = rs.getString("role");
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User(userId,userLogin,userPassword,new Role(userRole));

        return user;
    }

    public Boolean userLogin(String login, String password) {
        try {
            Connection connection = ConnectionPool.connection().getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM client WHERE login = ? AND password = ?");

            ps.setString(1,login);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            boolean b =  rs.next();
            ps.close();
            connection.close();

            return b;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void delete(String id){
        Connection connection = null;
        PreparedStatement ps = null;
        try {


            connection = ConnectionPool.connection().getConnection();

            ps = connection.prepareStatement("DELETE client WHERE id = ?");
            ps.setInt(1,  Integer.parseInt(id));
            ps.executeUpdate();
            System.out.println("Record is deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
        }
    }

}
