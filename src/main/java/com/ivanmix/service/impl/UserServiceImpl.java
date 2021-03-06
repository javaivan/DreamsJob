package com.ivanmix.service.impl;

import com.google.common.collect.Lists;
import com.ivanmix.entity.User;
import com.ivanmix.entity.UserRole;
import com.ivanmix.form.PasswordForm;
import com.ivanmix.form.ProfileForm;
import com.ivanmix.form.RegistrationForm;
import com.ivanmix.helper.ServiceHelper;
import com.ivanmix.models.UploadImage;
import com.ivanmix.repository.UserRepository;
import com.ivanmix.repository.UserRoleRepository;
import com.ivanmix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User createUser(RegistrationForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setLogin(form.getLogin());

        String encoderPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encoderPassword);

        user = userRepository.save(user);

        if( form.getRole()!=null){
            Set<UserRole> userRoles = new HashSet<UserRole>();
            UserRole role = new UserRole();
            role.setUser(user);
            role.setRole("ROLE_" + form.getRole().toUpperCase());
            userRoleRepository.save(role);
        }

        return user;
    }

    @Override
    @Transactional
    public void updateUser(Long id, ProfileForm form) {
        User user = userRepository.findById(id);
        user.setLogin(form.getLogin());
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUserPassword(Long id, PasswordForm form) {
        User user = userRepository.findById(id);
        String encoderPassword = passwordEncoder.encode(form.getPassword());
        user.setPassword(encoderPassword);
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll(ServiceHelper.getSortById()));
    }

    public List<UserRole> findByRole(String role, int page, int size){
        return userRoleRepository.findByRole(role, new PageRequest(page, size, ServiceHelper.getSortById()));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    @Transactional
    public void addUserPhoto(Long id, UploadImage image){
        User user = userRepository.findById(id);

        user.setBigImage(image.getBigImage());
        user.setSmallImage(image.getSmallImage());
        userRepository.save(user);
    }
}
