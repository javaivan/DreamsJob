package com.ivanmix.service;



import com.ivanmix.model.User;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by mix on 27.02.2016.
 */
public class UserService {

    private static final UserService instance = new UserService();

    private final List<User> users = new CopyOnWriteArrayList<User>();

    private UserService(){
        users.add(new User("1","Petr"));
        users.add(new User("2","Oleg"));
        users.add(new User("3","Ivan"));
    }

    public static UserService getInstance(){
        return instance;
    }

    public List<User> getAll(){
        return this.users;
    }

    public void add(final User user){
        this.users.add(user);
    }
/*    public User getUserById(Integer id){
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
    }*/

}
