package com.ivanmix.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by ivan on 31.07.2016.
 */
public class CurrentUser extends User {

    private final Long id;

    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id) {
        super(username, password, authorities);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

/*
    private final Long id;

    public CurrentUser(com.ivanmix.entity.User user) {
        super(user.getLogin(), user.getPassword(), user);
    }*/
}
