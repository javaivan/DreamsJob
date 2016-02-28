package com.ivanmix.service;



import com.ivanmix.model.User;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by mix on 27.02.2016.
 */
public class UserService {

    private volatile Map<Integer, User> userList = new HashMap<Integer, User>();

    private static UserService instance;

    private UserService(){}

    public static UserService getInstance(){
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User getUserById(Integer id){
        return userList.get(id);
    }

    public void setUser(int i, User user){
        userList.put(user.getId(), user);
    }

    public List<User> allUsers(){
        List<User> allUsers = new ArrayList<User>(userList.values());
        return allUsers;
    }
    public void deleteUserById(Integer id){
        userList.remove(id);
    }
    public void updateUser(User user){
        userList.put(user.getId(),user);
    }

}
