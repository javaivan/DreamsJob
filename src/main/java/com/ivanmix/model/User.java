package com.ivanmix.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by mix on 27.02.2016.
 */
public class User {
    private volatile static int count = 1;

    private synchronized int synchronizedCount(){
        return count++;
    }

    private Integer id;
    private Integer age;
    private float height;
    private Calendar dateBirth;
    private String name;


    public User(){
        this.id = synchronizedCount();
    }
    public User(String name){
        this.id = synchronizedCount();
        this.name = name;

    }

    public User(Integer age, float height, Calendar dateBirth, String name) {
        this.id = synchronizedCount();
        this.age = age;
        this.height = height;
        this.dateBirth = dateBirth;
        this.name = name;
    }

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }



    @Override
    public String toString() {

        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        return "User[id='"+this.id+"'; age='"+this.age+"'; height='"+this.height+"'; dateBirth='"+curFormater.format(this.dateBirth.getTime())+"'; name='"+this.name+"']";
    }



}
