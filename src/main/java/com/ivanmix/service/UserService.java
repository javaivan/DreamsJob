package com.ivanmix.service;

import com.ivanmix.dao.UserDAO;
import com.ivanmix.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    private UserDAO userDAO = new UserDAO();

    public int addUser(User user){
        logger.debug("addUser: " + user);
        return  userDAO.addUser(user);
    }

    public User getUserId(int id){
        logger.debug("getUserId: " + id);
        return userDAO.getUserById(id);
    }

    public User getUserByLoginAndPassword(String login, String password){
        logger.debug("getUserByLoginAndPassword: " + login + " || " + password);
        return userDAO.getUserByLoginAndPassword(login, password);
    }

    public void updateUser(User user){
        logger.debug("updateUser: " + user);
        userDAO.updateUser(user);
    }

    public List<User> getAllUser(){
        logger.debug("getAllUser");
        return userDAO.getAllUser();
    }
}
