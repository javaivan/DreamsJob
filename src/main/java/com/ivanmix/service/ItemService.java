package com.ivanmix.service;


import com.ivanmix.model.Item;
import com.ivanmix.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mix on 27.02.2016.
 */
public class ItemService {

    private static final ItemService instance = new ItemService();

    private final Map<String,Item>  items = new ConcurrentHashMap<String, Item>();

    private final HashSet<String> itemPublicList = new HashSet<String>();

    List<String> listItems = new LinkedList<String>();

    private AtomicInteger counter = new AtomicInteger(0);

    public  int getNextUniqueIndex() {
        return counter.getAndIncrement();
    }

    private ItemService(){
        items.put("1",new Item("1","1","1","1",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("2",new Item("2","1","2","2",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("3",new Item("3","1","3","3",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("4",new Item("4","1","4","4",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("5",new Item("5","1","5","5",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("6",new Item("6","1","6","6",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("7",new Item("7","1","7","7",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("8",new Item("8","1","8","8",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("9",new Item("9","1","9","9",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("10",new Item("10","2","10","10",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("11",new Item("11","2","11","11",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("12",new Item("12","2","12","12",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("13",new Item("13","2","13","13",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("14",new Item("14","2","14","14",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("15",new Item("15","2","15","15",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("16",new Item("16","2","16","16",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("17",new Item("17","2","17","17",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("18",new Item("18","2","18","18",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("19",new Item("19","2","19","19",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("20",new Item("20","2","20","20",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
    }

    public static ItemService getInstance(){
        return instance;
    }
    public Item get(String id){
        return this.items.get(id);
    }
    public String getItemUserId(String id){
        return this.items.get(id).getUserId();
    }
    public List<Item> getAll(){
        return new ArrayList<Item>(items.values());
    }

    public List<Item> getMyItems(String userID){
        User user = UserService.getInstance().get(userID);
        if(user.getRole().equalsIgnoreCase("ADMIN")){
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



    public List<String> getItemPublicList(){
        return  new ArrayList<String> (this.itemPublicList);
    }

    public List<Item> getItemAll(List<String> itemList){
        List<Item> getItems = new ArrayList<Item>();
        for (String id: itemList){
            getItems.add(get(id.trim()));
        }
        return getItems;
    }

    public List<Item> getPublicItem(){
        List<Item> publicItem = new ArrayList<Item>();

        for (String id: getItemPublicList()){
            publicItem.add(get(id));
        }
        return publicItem;
    }


    public void add(final Item item) {
        String itemId = String.valueOf(getNextUniqueIndex());
        Item itemNew = new Item(itemId, item.getId(),item.getName(), item.getDescription(),item.getCreating(),item.getListItems());
        itemPublicList.add(itemId);
        this.items.put(itemId,itemNew);
    }
    public void addItems(String itemId, String userId,  List<String> items){
        List<String> insertItems = new ArrayList<String>();

        for (String item: items){
            if(this.getItemUserId(item).equals(userId)){
                insertItems.add(item);
            }
        }

        Item oldItem = this.getInstance().get(itemId);
        Item newItem = new Item(oldItem.getId(),oldItem.getUserId(),oldItem.getName(), oldItem.getDescription(),oldItem.getCreating(),insertItems);
        ItemService.getInstance().add(newItem);
    }


    public void removeItemsInItem(String itemId, String[] items){
        Item oldItem = this.getInstance().get(itemId);
        List<String> listItems = oldItem.getListItems();

        for (String it : items) {
            listItems.remove(it);
        }

        Item newItem = new Item(oldItem.getId(),oldItem.getUserId(),oldItem.getName(), oldItem.getDescription(),oldItem.getCreating(),listItems);
        ItemService.getInstance().add(newItem);
    }












    public void addToPublic(String userID, String[] items){
        User user = UserService.getInstance().get(userID);
        if(user.getRole().equalsIgnoreCase("ADMIN")){
            for (String item: items){
                itemPublicList.add(item);
            }
        } else {
            for (String item: items){
                if(ItemService.getInstance().get(item).getUserId().equalsIgnoreCase(userID)){
                    itemPublicList.add(item);
                }
            }
        }
    }
    public void removeFromPublic(String userID, String[] items){
        User user = UserService.getInstance().get(userID);
        if(user.getRole().equalsIgnoreCase("ADMIN")){
            for (String item: items){
                itemPublicList.remove(item);
            }
        } else {
            for (String item: items){
                if(ItemService.getInstance().get(item).getUserId().equalsIgnoreCase(userID)){
                    itemPublicList.remove(item);
                }
            }
        }
    }



}
