package com.ivanmix.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Item {

    private final String id;
    private final String user;
    private final String parent;
    private final String name;
    private final String description;
    private final Date creating;
    private final Set<String> children;

    public Item(String id, String user, String parent, String name, String description, Date creating, Set<String> children) {
        this.id = id;
        this.user = user;
        this.parent = parent;
        this.name = name;
        this.description = description;
        this.creating = creating;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getParent() {
        return parent;
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

    public Set<String> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", parent='" + parent + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creating=" + creating +
                ", children=" + children +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (user != null ? !user.equals(item.user) : item.user != null) return false;
        if (parent != null ? !parent.equals(item.parent) : item.parent != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (creating != null ? !creating.equals(item.creating) : item.creating != null) return false;
        return children != null ? children.equals(item.children) : item.children == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creating != null ? creating.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        return result;
    }
}
