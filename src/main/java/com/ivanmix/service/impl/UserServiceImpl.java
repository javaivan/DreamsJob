package com.ivanmix.service.impl;

import com.google.common.collect.Lists;
import com.ivanmix.entity.User;
import com.ivanmix.entity.UserRole;
import com.ivanmix.form.RegistrationForm;
import com.ivanmix.repository.UserRepository;
import com.ivanmix.repository.UserRoleRepository;
import com.ivanmix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public User findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User createUser(RegistrationForm registrationForm) {
        User user = new User();
        user.setEmail(registrationForm.getEmail());
        user.setLogin(registrationForm.getLogin());


        String encoderPassword = passwordEncoder.encode(registrationForm.getConfirmPassword());
        user.setPassword(encoderPassword);

        user = userRepository.save(user);

        Set<UserRole> userRoles = new HashSet<UserRole>();
        UserRole role = new UserRole();
        role.setUser(user);
        role.setRole("ROLE_" + registrationForm.getRole().toUpperCase());
        userRoleRepository.save(role);

        return user;
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }
}
