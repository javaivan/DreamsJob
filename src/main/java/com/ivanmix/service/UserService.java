package com.ivanmix.service;

import com.ivanmix.entity.User;
import com.ivanmix.form.PasswordForm;
import com.ivanmix.form.ProfileForm;
import com.ivanmix.form.RegistrationForm;

import java.util.List;

public interface UserService {

    User findUserByLogin(String login);

    User findUserById(Long id);

    User createUser(RegistrationForm form);

    void updateUser(Long id, ProfileForm form);

    void updateUserPassword(Long id, PasswordForm form);

    List<User> findAll();

    void deleteUser(Long id);
}
