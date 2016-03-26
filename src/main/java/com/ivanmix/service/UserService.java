package com.ivanmix.service;



import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import sun.invoke.empty.Empty;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by mix on 27.02.2016.
 */
public class UserService {

    private static final UserService instance = new UserService();

    private final Map<String,User>  users = new ConcurrentHashMap<String, User>();

    //private final List<User> users = new CopyOnWriteArrayList<User>();

    private UserService(){
        users.put("1",new User("1","admin","admin",new Role("ADMIN")));
        users.put("2",new User("2","oleg","oleg",new Role("USER")));
        users.put("3",new User("3","Ivan","ivan", new Role("USER")));
    }

    public static UserService getInstance(){
        return instance;
    }

    public List<User> getAll(){
        return new ArrayList<User>(users.values());
    }

    public void add(final User user){
        this.users.put(user.getId(),user);
    }

    public User get(String id){
        return this.users.get(id);
    }
    public void deleted(String id){
        this.users.remove(id);
    }

    public User login(String login, String password){
        for (Map.Entry<String,User> us: users.entrySet()){
            User user = us.getValue();

            if(user.getLogin().equalsIgnoreCase(login) && user.getPassword().equalsIgnoreCase(password)) {
                return user;
            }
        }
        return null;
    }
}
