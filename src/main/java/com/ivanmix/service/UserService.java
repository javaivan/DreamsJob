package com.ivanmix.service;

import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import com.ivanmix.servlets.item.ItemMyListServlet;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class);

    private static final UserService instance = new UserService();

    private final Map<String,User>  users = new ConcurrentHashMap<String, User>();

    private UserService(){
        logger.debug("UserService");
        users.put("1",new User("1","admin","admin",new Role("ADMIN")));
        users.put("2",new User("2","oleg","oleg",new Role("USER")));
        users.put("3",new User("3","Ivan","ivan", new Role("USER")));
    }

    public static UserService getInstance(){
        logger.debug("getInstance");
        return instance;
    }

    public List<User> getAll(){
        logger.debug("getAll");
        return new ArrayList<User>(users.values());
    }

    public void add(final User user){
        logger.debug("add " + user);
        this.users.put(user.getId(),user);
    }

    public User get(String id){
        logger.debug("get " + id);
        return this.users.get(id);
    }

    public void delete(String id){
        logger.debug("getInstance: " + id);
        this.users.remove(id);
    }

    public User login(String login, String password){
        logger.debug("login: login " + login + "password " + password);
        for (Map.Entry<String,User> us: users.entrySet()){
            User user = us.getValue();

            if(user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }
}
