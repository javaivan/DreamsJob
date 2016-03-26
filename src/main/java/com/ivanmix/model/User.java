package com.ivanmix.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by mix on 27.02.2016.
 */
public class User {

    private final String id;
    private final String login;
    private final String password;
    private final Role role;

    public User(final String id, final String login, final String password, final Role role){
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public String getId(){
        return this.id;
    }
    public String getLogin(){
        return this.login;
    }
    public String getPassword(){
        return this.login;
    }
    public String getRole(){
        return role.getRule();
    }



/*
    @Override
    public String toString() {

        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        return "User[id='"+this.id+"'; dateBirth='"+curFormater.format(this.dateBirth.getTime())+"'; name='"+this.name+"']";
    }

*/

}
