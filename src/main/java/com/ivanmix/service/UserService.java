package com.ivanmix.service;

import com.ivanmix.entity.User;
import com.ivanmix.entity.UserRole;
import com.ivanmix.form.PasswordForm;
import com.ivanmix.form.ProfileForm;
import com.ivanmix.form.RegistrationForm;
import com.ivanmix.models.UploadImage;
import com.ivanmix.util.SecurityUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {

    User findUserByLogin(String login);

    User findUserById(Long id);

    User createUser(RegistrationForm form);

    void updateUser(Long id, ProfileForm form);

    void updateUserPassword(Long id, PasswordForm form);

    List<User> findAll();

    List<UserRole> findByRole(String role, int page, int size);

    void deleteUser(Long id);

    void addUserPhoto(Long id, UploadImage image);

}
