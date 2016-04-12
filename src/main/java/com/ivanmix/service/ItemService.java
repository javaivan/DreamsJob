package com.ivanmix.service;

import com.ivanmix.model.Item;
import com.ivanmix.model.User;
import com.ivanmix.servlets.item.ItemMyListServlet;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemService {
    private static final Logger logger = Logger.getLogger(ItemService.class);

    private static final ItemService instance = new ItemService();

    private final Map<String,Item>  items = new ConcurrentHashMap<String, Item>();

    private final HashSet<String> itemPublicList = new HashSet<String>();

    List<String> listItems = new LinkedList<String>();

    private AtomicInteger counter = new AtomicInteger(0);

    public  int getNextUniqueIndex() {
        logger.debug("getNextUniqueIndex");
        return counter.getAndIncrement();
    }

    private ItemService(){
        logger.debug("ItemService");
        items.put("1",new Item("1","1","Контент-редактор","Наполнение каталога товаров (технические характеристики и описание товаров)\n" +
                "Обновление и контроль базы товаров\n" +
                "Подготовка, обработка изображений для загрузки на сайт\n" +
                "Работа с vk.com и facebook.com\n" +
                "Написание текстов и подготовка новостей\n" +
                "Рассылка прайс-листов",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("2",new Item("2","1","Web дизайнер","Если Вы дизайнер, креатив из Вас так и льется, знаете что такое хорошие сайты и как они должны выглядеть, то мы рады будем принять Вас в наш дружный коллектив.",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("3",new Item("3","1","Front-end developer","— Реальный опыт в этом направлении от 1 года (HTML5, CSS3)\n" +
                "— JavaScript, опыт работы с JS-фреймворками и библиотеками (jQuery)\n" +
                "— Наличие портфолио ОБЯЗАТЕЛЬНО\n" +
                "— Опыт работы с системами контроля версий (GIT, SVN)\n" +
                "— Умение разбираться в чужом коде\n" +
                "— Адаптация макетов\n" +
                "— Чистота написания кода (Форматирование, комментарии, стандарты).",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("4",new Item("4","1","Project manager","Eastern Peak Software is looking for an English speaking experienced Project Manager to join the team.\n" +
                "We have many software projects for customers from United States, Europe and Israel. We use technologies, such as: PHP, RoR, Python, iOS, Android, JavaScript, jQuery, AngularJS, and others.",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("5",new Item("5","2","СММ-специалист","Производитель женской одежды бренд SL_IRA, осуществляющий деятельность в 5 странах мира, ищет в компанию СММ-специалиста",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("6",new Item("6","2","Сustomer Relationship Manager","Компания приглашает на работу сотрудника с опытом работы на аналогичной должности не менее года.",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("7",new Item("7","2","Frontend Developer","Компания приглашает на работу Frontend разработчика.",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
        items.put("8",new Item("8","2","Software marketing manager","Компания приглашает на работу Software marketing manager для продвижения программных продуктов и интернет ресурсов компании worldwide. ",new Date(), listItems));
        itemPublicList.add(String.valueOf(getNextUniqueIndex()));
    }

    public static ItemService getInstance(){
        logger.debug("getInstance");
        return instance;
    }

    public Item get(String id){
        logger.debug("get: id: " + id);
        return this.items.get(id);
    }

    public String getItemUserId(String id){
        logger.debug("getItemUserId: id: " + id);
        return this.items.get(id).getUserId();
    }

    public List<Item> getAll(){
        logger.debug("getAll");
        return new ArrayList<Item>(items.values());
    }

    public List<Item> getMyItems(String userID){
        logger.debug("getMyItems: userID: " + userID);
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
        logger.debug("getItemPublicList");
        return  new ArrayList<String> (this.itemPublicList);
    }

    public List<Item> getItemAll(List<String> itemList){
        logger.debug("getItemAll: itemList: " + itemList);
        List<Item> getItems = new ArrayList<Item>();
        for (String id: itemList){
            getItems.add(get(id.trim()));
        }
        return getItems;
    }

    public List<Item> getPublicItem(){
        logger.debug("getPublicItem");
        List<Item> publicItem = new ArrayList<Item>();

        for (String id: getItemPublicList()){
            publicItem.add(get(id));
        }
        return publicItem;
    }

    public void add(final Item item) {
        logger.debug("add " + item);
        String itemId = String.valueOf(getNextUniqueIndex());
        Item itemNew = new Item(itemId, item.getId(),item.getName(), item.getDescription(),item.getCreating(),item.getListItems());
        itemPublicList.add(itemId);
        this.items.put(itemId,itemNew);
    }

    public void addItems(String itemId,  List<String> items){
        logger.debug("addItems: itemId: " + itemId + "items: " + items);
        List<String> insertItems = new ArrayList<String>();
        String userId = this.get(itemId).getUserId();

        for (String item: items){
            if(this.get(item).getUserId().equals(userId)){
                insertItems.add(item);
            }
        }
        Item oldItem = this.getInstance().get(itemId);
        Item newItem = new Item(oldItem.getId(),userId,oldItem.getName(), oldItem.getDescription(),oldItem.getCreating(),insertItems);
        this.items.put(newItem.getId(),newItem);
    }

    public void removeItemsInItem(String itemId, String[] items){
        logger.debug("removeItemsInItem: itemId: " + itemId + " items: " + items);
        Item oldItem = this.getInstance().get(itemId);
        List<String> listItems = oldItem.getListItems();

        for (String it : items) {
            listItems.remove(it);
        }
        Item newItem = new Item(oldItem.getId(),oldItem.getUserId(),oldItem.getName(), oldItem.getDescription(),oldItem.getCreating(),listItems);
        ItemService.getInstance().add(newItem);
    }

    public void addToPublic(String userID, String[] items){
        logger.debug("addToPublic: userID: " + userID + "items: " + items);

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
        logger.debug("removeFromPublic: userID: " + userID + "items: " + items);

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
