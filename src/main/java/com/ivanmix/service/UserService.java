package com.ivanmix.service;

import com.ivanmix.entity.User;
import com.ivanmix.form.RegistrationForm;

import java.util.List;

public interface UserService {

    User findUserByLogin(String login);

    User createUser(RegistrationForm registrationForm);

    void updateUser(User user);

    List<User> findAll();
}
