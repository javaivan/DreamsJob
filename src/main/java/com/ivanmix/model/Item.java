package com.ivanmix.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mix on 26.03.2016.
 */
public class Item {

    private final String id;
    private final String userId;
    private final String name;
    private final String description;
    private final Date creating;
    private final List<String> listItems;

    public Item(String id, String userId, String name, String description, Date creating, List<String> listItems) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.creating = creating;
        this.listItems = listItems;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreating() {
        return creating;
    }

    public List<String> getListItems() {
        return listItems;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creating='" + creating + '\'' +
                '}';
    }
}
