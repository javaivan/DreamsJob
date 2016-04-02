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

    private final Map<String,Item>  items = new ConcurrentHashMap<String, Item>();


    private ItemService(){
        items.put("1",new Item("1","1","1","1"));
        items.put("2",new Item("2","2","2","2"));
        items.put("3",new Item("3","3","3","3"));
        items.put("4",new Item("4","4","4","4"));
        items.put("5",new Item("5","5","5","5"));
        items.put("6",new Item("6","6","6","6"));
        items.put("7",new Item("7","7","7","7"));
        items.put("8",new Item("8","8","8","8"));
        items.put("9",new Item("9","9","9","9"));
        items.put("10",new Item("10","10","10","10"));
        items.put("11",new Item("11","11","11","11"));
        items.put("12",new Item("12","12","12","12"));
        items.put("13",new Item("13","13","13","13"));
        items.put("14",new Item("14","14","14","14"));
        items.put("15",new Item("15","15","15","15"));
        items.put("16",new Item("16","16","16","16"));
        items.put("17",new Item("17","17","17","17"));
        items.put("18",new Item("18","18","18","18"));
        items.put("19",new Item("19","19","19","19"));
        items.put("20",new Item("20","20","20","20"));
    }

    public static ItemService getInstance(){
        return instance;
    }

    public List<Item> getAll(String userID, String userRole){

        if(userRole.equalsIgnoreCase("ADMIN")){
            return new ArrayList<Item>(items.values());
        } else {

            List<Item> getItems = new ArrayList<Item>();
            for (Map.Entry<String,Item> it: items.entrySet()){
                if(it.getValue().getUserId().equalsIgnoreCase(userID)){
                    getItems.add(it.getValue());
                }
            }
            return getItems;
        }
    }

    public List<Item> getItemAll(List<String> itemList){
        List<Item> getItems = new ArrayList<Item>();
        for (String id: itemList){
            getItems.add(get(id.trim()));
        }
        return getItems;
    }

    public void add(final Item item){
        this.items.put(item.getId(),item);
    }
    public Item get(String id){
        return this.items.get(id);
    }
}
