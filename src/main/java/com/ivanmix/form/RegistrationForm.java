package com.ivanmix.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @NotNull
    @Size(max=255, min = 5)
    private String login;

    @NotNull
    @Size(max=255, min = 5)
    private String email;

    @NotNull
    @Size(max=255, min = 5)
    private String password;

    @NotNull
    @Size(max=255, min = 5)
    private String confirmPassword;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
