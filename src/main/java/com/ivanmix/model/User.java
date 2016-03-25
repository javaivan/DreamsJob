package com.ivanmix.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by mix on 27.02.2016.
 */
public class User {

    private final String id;

    private final String login;

    public User(final String id, final String login){
        this.id = id;
        this.login = login;
    }

    public String getId(){
        return this.id;
    }
    public String getLogin(){
        return this.login;
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
