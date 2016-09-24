package com.ivanmix.validator;

import com.ivanmix.annotation.FieldExists;
import com.ivanmix.entity.User;
import com.ivanmix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FieldExistsConstraintValidator implements ConstraintValidator<FieldExists, Object> {
    private String login;
    private String email;

    @Autowired
    private UserService userService;

    @Override
    public void initialize(final FieldExists constraintAnnotation) {
        login = constraintAnnotation.login();
        email = constraintAnnotation.email();
    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        try {
            User userByLogin = userService.findUserByLogin(login);
            User userByEmail = userService.findByEmail(email);

            return userByLogin != null || userByEmail != null;
        } catch (Exception ignore) {
            return false;
        }
    }
}
