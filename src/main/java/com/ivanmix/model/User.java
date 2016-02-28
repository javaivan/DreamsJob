package com.ivanmix.model;

/**
 * Created by mix on 27.02.2016.
 */
public class User {
    private volatile static int count = 1;

    private synchronized int synchronizedCount(){
        return count++;
    }

    private int id;
    private String name;

    public User(){
        this.id = synchronizedCount();
    }
    public User(String name){
        this.id = synchronizedCount();
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

    @Override
    public String toString() {
        return "User[id='"+this.id+"'; name='"+this.name+"']";
    }
}
