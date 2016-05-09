package com.ivanmix.service;

import com.ivanmix.helper.ItemBilder;
import com.ivanmix.model.Item;
import com.ivanmix.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemService {

    private static final Logger logger =
            LoggerFactory.getLogger(ItemService.class);

    private static final ItemService instance = new ItemService();

    private final Map<String,Item>  items = new ConcurrentHashMap<String, Item>();

    private final HashSet<String> itemPublicList = new HashSet<String>();



    private AtomicInteger counter = new AtomicInteger(1);


    private int getNextUniqueIndex() {
        logger.debug("getNextUniqueIndex");
        return counter.getAndIncrement();
    }

    private ItemService(){
        logger.debug("ItemService");
        String id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"1","0","Контент-редактор","Наполнение каталога товаров (технические характеристики и описание товаров)\n" +
                "Обновление и контроль базы товаров\n" +
                "Подготовка, обработка изображений для загрузки на сайт\n" +
                "Работа с vk.com и facebook.com\n" +
                "Написание текстов и подготовка новостей\n" +
                "Рассылка прайс-листов",new Date(), new HashSet<String>()));
        id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"1","0","Web дизайнер","Если Вы дизайнер, креатив из Вас так и льется, знаете что такое хорошие сайты и как они должны выглядеть, то мы рады будем принять Вас в наш дружный коллектив.",new Date(), new HashSet<String>()));
        id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"1","0","Front-end developer","— Реальный опыт в этом направлении от 1 года (HTML5, CSS3)\n" +
                "— JavaScript, опыт работы с JS-фреймворками и библиотеками (jQuery)\n" +
                "— Наличие портфолио ОБЯЗАТЕЛЬНО\n" +
                "— Опыт работы с системами контроля версий (GIT, SVN)\n" +
                "— Умение разбираться в чужом коде\n" +
                "— Адаптация макетов\n" +
                "— Чистота написания кода (Форматирование, комментарии, стандарты).",new Date(), new HashSet<String>()));
        id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"1","0","Project manager","Eastern Peak Software is looking for an English speaking experienced Project Manager to join the team.\n" +
                "We have many software projects for customers from United States, Europe and Israel. We use technologies, such as: PHP, RoR, Python, iOS, Android, JavaScript, jQuery, AngularJS, and others.",new Date(), new HashSet<String>()));
        id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"2","0","СММ-специалист","Производитель женской одежды бренд SL_IRA, осуществляющий деятельность в 5 странах мира, ищет в компанию СММ-специалиста",new Date(), new HashSet<String>()));
        id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"2","0","Сustomer Relationship Manager","Компания приглашает на работу сотрудника с опытом работы на аналогичной должности не менее года.",new Date(), new HashSet<String>()));
        id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"2","0","Frontend Developer","Компания приглашает на работу Frontend разработчика.",new Date(), new HashSet<String>()));
        id = String.valueOf(getNextUniqueIndex());
        items.put(id,new Item(id,"2","0","Software marketing manager","Компания приглашает на работу Software marketing manager для продвижения программных продуктов и интернет ресурсов компании worldwide. ",new Date(), new HashSet<String>()));
    }


    /**
     *
     * @return
     */
    public static ItemService getInstance(){
        logger.debug("getInstance");
        return instance;
    }

    /**
     * @param id
     * @return Item
     */
    public Item get(String id){
        logger.debug("get: id: " + id);
        return this.items.get(id);
    }

    /**
     * @param String
     * @return List<Item>
     */
    public List<Item> getMyItems(String userID){
        logger.debug("getMyItems: userID: " + userID);
        User user = UserService.getInstance().get(userID);
        if(user.getRole().equalsIgnoreCase("ADMIN")){
            return new ArrayList<Item>(items.values());
        } else {
            List<Item> getItems = new ArrayList<Item>();
            for (Map.Entry<String,Item> it: items.entrySet()){
                if(it.getValue().getUser().equalsIgnoreCase(userID)){
                    getItems.add(it.getValue());
                }
            }
            return getItems;
        }
    }

    /**
     * @return List<Item>
     */
    public List<Item> getItemAll(){
        logger.debug("getItemAll");
        return  new ArrayList<Item>(items.values());
    }


    /**
     * @param itemList
     * @return List<Item>
     */
    public List<Item> getItemAll(Set<String> itemList){
        logger.debug("getItemAll: itemList: " + itemList);
        List<Item> getItems = new ArrayList<Item>();
        for (String id: itemList){
            getItems.add(get(id.trim()));
        }
        return getItems;
    }

    /**
     * @param  Item item
     * @return Add new Item
     */
    public void add(final Item item) {
        logger.debug("add " + item);
        String itemId = String.valueOf(getNextUniqueIndex());
        Item itemNew = new Item(itemId, item.getId(),"0",item.getName(), item.getDescription(),item.getCreating(),item.getChildren());
        this.items.put(itemId,itemNew);
    }

    /**
     * @return List<Item>
     */
    public List<Item> getItemFirstLevel(){

        logger.debug("getItemFirstLevel");

        Set<String> itemAll = new HashSet<String>();
        Set<String> itemWithParent = new HashSet<String>();
        for (Item item: this.items.values()){
           itemAll.add(item.getId());
           for (String id: item.getChildren()){
               itemWithParent.add(id);
           }
        }
        for (String id: itemWithParent){
            itemAll.remove(id);
        }

        List<Item> publicItem = new ArrayList<Item>();
        for (String id: itemAll){
            publicItem.add(get(id));
        }
        return publicItem;
    }




    /**
     * @param  Item id
     * @return boolean
     */
    public boolean exitTofirstLevel(String id, int amountRepetitions, int maxAmountRepetitions){
        if(amountRepetitions > maxAmountRepetitions){
            return false;
        }
        String parent = items.get(id).getParent();
        if(parent.equals("0")){
            return true;
        } else {
            amountRepetitions++;
            exitTofirstLevel(parent, amountRepetitions, maxAmountRepetitions);
        }
        return false;
    }

    /**
     * @param itemId, userId, parent, name, description
     */
    public void updateItem(String itemId, String userId, String parent, String name, String  description){
        logger.debug("updateItem: itemId: " + itemId + " userId: " + userId + " parent: " + parent + " name: " + name + " description: " + description);

        Item itemOld = this.items.get(itemId);
        User user = UserService.getInstance().get(userId);
        if(user.getRole().equalsIgnoreCase("ADMIN") || (user.getId().equalsIgnoreCase(userId))){
            if(!itemOld.getParent().equalsIgnoreCase(parent)){
                if(exitTofirstLevel(parent,0,items.size())) {
                    this.updateParent(parent, itemId);
                }
            }
            Item newItem = ItemBilder.newItem(itemOld, parent, name, description);
            this.items.put(newItem.getId(),newItem);
        }

    }

    /**
     * @param itemId, itemParentId
     */
    public void updateParent(String itemId, String itemParentId){
        Item itemOld = this.items.get(itemParentId);
        Set<String> itemChilder = itemOld.getChildren();
        if(itemParentId.equalsIgnoreCase("0")){
            itemChilder.remove(itemId);
        } else{
            itemChilder.add(itemId);
        }
        Item newItem = ItemBilder.newItem(itemOld, itemChilder);
        this.items.put(newItem.getId(),newItem);
    }
}
