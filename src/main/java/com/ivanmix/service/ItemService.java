package com.ivanmix.service;


import com.ivanmix.model.Item;
import com.ivanmix.model.Role;
import com.ivanmix.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by mix on 27.02.2016.
 */
public class ItemService {

    private static final ItemService instance = new ItemService();


    private final List<Item> items = new CopyOnWriteArrayList<Item>();

    private ItemService(){
        items.add(new Item("1","1","1","1"));
        items.add(new Item("2","2","2","2"));
        items.add(new Item("3","3","3","3"));
    }

    public static ItemService getInstance(){
        return instance;
    }

    public List<Item> getAll(String userID, String userRole){
        if(userRole.equalsIgnoreCase("ADMIN")){
            return this.items;
        } else {

            List<Item> getItems = new ArrayList<Item>();
            for (Item item: this.items){
                if(item.getUserId().equalsIgnoreCase(userID)){
                    getItems.add(item);
                }
            }
            return getItems;
        }
    }



    public void add(final Item item){
        this.items.add(item);
    }
}
