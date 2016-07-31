package com.ivanmix.service;

import com.ivanmix.entity.User;

import java.util.List;

public interface UserService {

    User findUserByLogin(String login);

    User createUser(User user);

    void updateUser(User user);

    List<User> findAll();
}
