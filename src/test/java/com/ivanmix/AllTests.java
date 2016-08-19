package com.ivanmix;

import com.ivanmix.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.*;

import static org.junit.Assert.assertNotNull;


public class AllTests {

    @BeforeClass
    public static void init(){
        System.out.println("Before all");

        String url = "jdbc:postgresql://127.0.0.1:5432/dreams_job";
        String user = "dreams_job";
        String password = "dreams_job";

        try (Connection con = DriverManager.getConnection(url, user, password)){
            insertUserToDelete(con);
            insertUserToGetByIdAndLogin(con);
            deleteUser(con);


            insertReplyToFindByReply(con);
            deleteReply(con);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    @Test
    public void initTest() {

        System.out.println("initTest OK");
    }




    private static void insertUserToDelete(Connection con) throws SQLException {
        int id = 2;
        String userLogin = "Test User Login";
        String userEmail = "Test User Email";
        String userPassword = "Test User passwpord";
        String stm = "INSERT INTO users(id, login, email, password) VALUES(?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(stm);
        pst.setInt(1, id);
        pst.setString(2, userLogin);
        pst.setString(3, userEmail);
        pst.setString(4, userPassword);
        pst.executeUpdate();
    }

    private static void insertUserToGetByIdAndLogin(Connection con) throws SQLException {
        String stmDelete = "DELETE FROM users WHERE id =?";
        PreparedStatement pstDelete = con.prepareStatement(stmDelete);
        pstDelete.setLong(1, 3);
        pstDelete.executeUpdate();

        int id = 3;
        String userLogin = "testGetUserLogin";
        String userEmail = "testGetUserEmail@gmail.com";
        String userPassword = "Test User passwpord";
        String stm = "INSERT INTO users(id, login, email, password) VALUES(?, ?, ?, ?)";
        PreparedStatement pstGetUser = con.prepareStatement(stm);
        pstGetUser.setInt(1, id);
        pstGetUser.setString(2, userLogin);
        pstGetUser.setString(3, userEmail);
        pstGetUser.setString(4, userPassword);
        pstGetUser.executeUpdate();
    }

    private static void deleteUser(Connection con) throws SQLException {
        String stm = "DELETE FROM users WHERE login =?";
        PreparedStatement pst = con.prepareStatement(stm);
        pst.setString(1, "TestCreateUserLogin");
        pst.executeUpdate();
    }


    private static void insertReplyToFindByReply(Connection con) throws SQLException {

        String stmDelete = "DELETE FROM project_reply WHERE id =?";
        PreparedStatement pstDelete = con.prepareStatement(stmDelete);
        pstDelete.setLong(1, 1);
        pstDelete.executeUpdate();

        int id = 1;
        int projectID = 1;
        int userID = 1;
        String reply = "TestFindByReply";
        String stm = "INSERT INTO project_reply(id, project, reply, user) VALUES(?, ?, ?, ?)";
        PreparedStatement pstReply = con.prepareStatement(stm);
        pstReply.setInt(1, id);
        pstReply.setInt(2, projectID);
        pstReply.setString(3, reply);
        pstReply.setInt(4, userID);
        pstReply.executeUpdate();
    }

    private static void deleteReply(Connection con) throws SQLException {
        String stm = "DELETE FROM project_reply WHERE reply =?";
        PreparedStatement pst = con.prepareStatement(stm);
        pst.setString(1, "TestCreateReplyReplyParent");
        pst.executeUpdate();

        pst.setString(1, "TestCreateReplyReplyChildren");
        pst.executeUpdate();
    }
}
