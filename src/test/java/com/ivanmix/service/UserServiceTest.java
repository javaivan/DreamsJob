package com.ivanmix.service;

import com.ivanmix.config.SpringConfig;
import com.ivanmix.entity.User;
import com.ivanmix.form.RegistrationForm;
import com.ivanmix.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    @Test
    public void deleteUser() {
        User user = repository.findById((long) 2);
        assertNotNull(user);
        userService.deleteUser((long) 2);
        user = repository.findById((long) 2);
        assertNull(user);
    }
    @Test
    public void createUserTest(){

        User user = repository.findByLogin("TestCreateUserLogin");
        assertNull(user);

        RegistrationForm form = new RegistrationForm();
        form.setLogin("TestCreateUserLogin");
        form.setPassword("TestCreateUserPassword");
        form.setEmail("TestCreateUserEmail");

        userService.createUser(form);

        user = repository.findByLogin("TestCreateUserLogin");
        assertNotNull(user);
    }

    @Test
    public void findUserByLoginTest(){
        User user = userService.findUserByLogin("testGetUserLogin");
        assertNotNull(user);
    }

    @Test
    public void findUserByLoginId(){
        User user = userService.findUserById((long) 3);
        assertNotNull(user);
    }


}
