package com.ivanmix.service;

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

    /**
     * @return List<User>
     */
    public List<User> getAll(){
        logger.debug("getAll");
        return new ArrayList<User>(users.values());
    }

    /**
     * @param  User user
     */
    public void add(final User user){
        logger.debug("add " + user);
        this.users.put(user.getId(),user);
    }


    /**
     * @param  User user
     */
    /*
    public void update(final User user){
        logger.debug("add " + user);
        User oldUser = this.users.get(user.getId());

        this.users.put(user.getId(),user);
    }*/

    /**
     * @param  String id
     * @return User
     */
    public User get(String id){
        logger.debug("get " + id);
        if(this.users.get(id) != null){
            return this.users.get(id);
        }
        throw new IllegalStateException(String.format("Not found user with id %s", id));
    }

    /**
     * @param  String id
     */
    public void delete(String id){
        logger.debug("getInstance: " + id);
        this.users.remove(id);
    }

    /**
     * @param  String login, String password
     * @return User
     */
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
