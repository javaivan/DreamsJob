package com.ivanmix.model;

import java.util.Date;
import java.util.List;

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
                ", creating=" + creating +
                ", listItems=" + listItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (!id.equals(item.id)) return false;
        if (!userId.equals(item.userId)) return false;
        if (!name.equals(item.name)) return false;
        if (!description.equals(item.description)) return false;
        if (!creating.equals(item.creating)) return false;
        return listItems != null ? listItems.equals(item.listItems) : item.listItems == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + userId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + creating.hashCode();
        result = 31 * result + (listItems != null ? listItems.hashCode() : 0);
        return result;
    }
}
