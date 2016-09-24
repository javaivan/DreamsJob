package com.ivanmix.form;

import com.ivanmix.annotation.FieldExists;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldExists(login = "login", email = "email", message = "The user is exists")
public class RegistrationForm extends PasswordForm {

    @NotNull
    @Size(max=255, min = 5)
    private String login;

    @NotNull
    @Size(max=255, min = 5)
    private String email;

    @NotNull
    @Size(max=10, min = 1)
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
