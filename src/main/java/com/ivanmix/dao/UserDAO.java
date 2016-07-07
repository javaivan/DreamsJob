package com.ivanmix.dao;


import com.ivanmix.configuration.ConnectionPool;
import com.ivanmix.exception.UserIsNotFound;
import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import com.ivanmix.service.ItemService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivan on 23.05.2016.
 */
public class UserDAO {
    private static final Logger logger =
            LoggerFactory.getLogger(UserDAO.class);

    public void add(User user){
        logger.debug("add");
        try (Connection con = ConnectionPool.connection().getConnection()){
            PreparedStatement ps = con.prepareStatement("insert into client values (nextval('client_seq'),?,?,?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(String.valueOf(e));
        }
    }




    public User get(String id) throws UserIsNotFound {
        logger.debug("get");
        try (Connection con = ConnectionPool.connection().getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String userId = rs.getString("id");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");
                String userRole = rs.getString("role");

                User user = new User(userId, userLogin, userPassword, new Role(userRole));
                return user;
            } else {
                throw new UserIsNotFound();
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e));
        }
        throw new UserIsNotFound();
    }

    public User getUser(String login) throws UserIsNotFound {
        logger.debug("getUser");
        try (Connection con = ConnectionPool.connection().getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE login = ?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String userId = rs.getString("id");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");
                String userRole = rs.getString("role");

                User user = new User(userId, userLogin, userPassword, new Role(userRole));
                return user;
            } else {
                throw new UserIsNotFound();
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e));
        }
        throw new UserIsNotFound();
    }

    public User userLogin(String login, String password) throws UserIsNotFound {
        logger.debug("userLogin");
        try (Connection con = ConnectionPool.connection().getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM client WHERE login = ? AND password = ?");
            ps.setString(1,login);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                String userId = rs.getString("id");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");
                String userRole = rs.getString("role");

                User user = new User(userId, userLogin, userPassword, new Role(userRole));
                return user;
            } else {
                throw new UserIsNotFound();
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e));
        }
        throw new UserIsNotFound();
    }

    public void delete(String id){
        logger.debug("delete" + id);
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = ConnectionPool.connection().getConnection();
            ps = connection.prepareStatement("DELETE FROM client WHERE id = ?");
            ps.setInt(1,  Integer.parseInt(id));
            //ps.executeUpdate();
            ps.execute();
            connection.commit();
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

    public List<User> getAll(){
        logger.debug("getAll");
        List<User> users = new ArrayList<>();

        try (Connection con = ConnectionPool.connection().getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM client");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                String userId = rs.getString("id");
                String userLogin = rs.getString("login");
                String userPassword = rs.getString("password");
                String userRole = rs.getString("role");

                User user = new User(userId, userLogin, userPassword, new Role(userRole));
                users.add(user);
            }

        } catch (SQLException e) {
            logger.error(String.valueOf(e));
        }
        return users;
    }

}
