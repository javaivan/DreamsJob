package com.ivanmix.form;

import com.ivanmix.annotation.FieldExists;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldExists(login = "login", email = "email", message = "The user is exists")
public class ProfileForm {

    @NotNull
    @Size(max=255, min = 5)
    private String login;

    @NotNull
    @Size(max=255, min = 5)
    private String email;

    @NotNull
    @Size(max=255, min = 5)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(max=255, min = 5)
    @Column(name = "last_name")
    private String lastName;

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


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ProfileForm{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
