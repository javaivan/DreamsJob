package com.ivanmix.service;

import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ivan on 09.05.2016.
 */
public class UserServiceTest {


    @Test
    public void getAll() throws Exception {
        assertFalse(UserService.getInstance().getAll().isEmpty());
    }

    @Test
    public void add() throws Exception {
        int numberUsers = UserService.getInstance().getAll().size();
        numberUsers ++;
        UserService.getInstance().add(new User("10", "10", "10", new Role("USER")));
        assertEquals(numberUsers,UserService.getInstance().getAll().size());
    }


    @Test
    public void get() throws Exception {
        User user = UserService.getInstance().get("1");
        assertEquals("admin",user.getLogin());
        assertEquals("admin",user.getPassword());
    }

    @Test
    public void delete() throws Exception {
        int numberUsers = UserService.getInstance().getAll().size();
        numberUsers --;
        UserService.getInstance().delete("2");
        assertEquals(numberUsers,UserService.getInstance().getAll().size());


    }


}