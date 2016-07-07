package com.ivanmix.service;

import com.ivanmix.dao.UserDAO;
import com.ivanmix.exception.UserIsNotFound;
import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    private static final UserService instance = new UserService();

    private UserDAO userDAO = new UserDAO();

    private final Map<String,User>  users = new ConcurrentHashMap<String, User>();

    private UserService(){
        logger.debug("UserService");
        users.put("1",new User("1","admin","admin",new Role("ADMIN")));
        users.put("2",new User("2","oleg","oleg",new Role("USER")));
        users.put("3",new User("3","Ivan","ivan333", new Role("USER")));
    }

    public static UserService getInstance(){
        logger.debug("getInstance");
        return instance;
    }

    /**
     * @return List<User>
     */
    public List<User> getAll(){
        logger.debug("getAll");
        return userDAO.getAll();
    }


    public void add(final User user){
        logger.debug("add " + user);
        userDAO.add(user);
    }



    /*
    public void update(final User user){
        logger.debug("add " + user);
        User oldUser = this.users.get(user.getId());

        this.users.put(user.getId(),user);
    }*/


    public User get(String id){
        logger.debug("get " + id);

        try {
            return userDAO.get(id);
        } catch (UserIsNotFound userIsNotFound) {
            logger.error(String.valueOf(userIsNotFound));
            return null;
        }
    }


    public void delete(String id){
        logger.debug("getInstance: " + id);
        userDAO.delete(id);
    }


    public User login(String login, String password){

        logger.debug("login: login " + login + "password " + password);
        try {
            return userDAO.userLogin(login,password);
        } catch (UserIsNotFound userIsNotFound) {
            logger.error(String.valueOf(userIsNotFound));
            return null;
        }
    }
}
