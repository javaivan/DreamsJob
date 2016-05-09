package com.ivanmix.helper;

import com.ivanmix.model.Item;

import java.util.Set;


public class ItemBilder {

    public static Item newItem(Item item, Set<String> items){
        return new Item(item.getId(), item.getUser(), item.getParent(), item.getName(), item.getDescription(), item.getCreating(), items);
    }

    public static Item newItem(Item item, String parent){
        return new Item(item.getId(), item.getUser(), parent, item.getName(), item.getDescription(), item.getCreating(), item.getChildren());
    }

    public static Item newItem(Item item, String parent, String name, String description){
        return new Item(item.getId(), item.getUser(), parent, name, description, item.getCreating(), item.getChildren());
    }

}
