package com.ivanmix.service;

import com.ivanmix.configuration.HibernateUtil;
import com.ivanmix.dao.UserDAO;
import com.ivanmix.entity.Account;
import com.ivanmix.exception.UserIsNotFound;
import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class UserService {

    public static void main(String[] args){

/*
        SessionFactory factory  = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
*/


      /*  User user = new User();
        //user.setId("20");
       /* user.setLogin("1test");
        user.setPassword("1test");
        //session.save(user);

        System.out.println(session.get(User.class,1));
        System.out.println(session.createQuery("from User").list());*/



        /*
        Account account = new Account();
        account.setLogin("root2");
        account.setPassword("root2");
        account.setRole("0");
        session.save(account);
        */


        ///////System.out.println(session.get(Account.class,7));
        /*
        System.out.println(session.createQuery("from Account a WHERE a.login = root");*/

/*
        String hql = "FROM Account a WHERE a.login = :login";
        Query query = session.createQuery(hql);
        query.setParameter("login","root");
        Account a = (Account)query.uniqueResult();
        System.out.println(a);*/


        /*
        List results = query.list();
        System.out.println(results);*/

        //////////////////System.out.println(session.createQuery("from Account ").list());

/*

        session.getTransaction().commit();
        session.close();
        factory.close();*/

  //      System.out.println(new UserDAO().getAccountById(7));
        System.out.println(new UserDAO().getAccountByLoginAndPassword("root","root"));
        System.out.println(new UserDAO().getAccountByLoginAndPassword("root","root"));

    }


    private static final Logger logger =
            LoggerFactory.getLogger(UserService.class);

    private static final UserService instance = new UserService();

    private UserDAO userDAO = new UserDAO();

    private final Map<String,User>  users = new ConcurrentHashMap<String, User>();

    private UserService(){
        logger.debug("UserService");
      /*  users.put("1",new User("1","admin","admin",new Role("ADMIN")));
        users.put("2",new User("2","oleg","oleg",new Role("USER")));
        users.put("3",new User("3","Ivan","ivan333", new Role("USER")));*/
    }

    public static UserService getInstance(){
        logger.debug("getInstance");
        return instance;
    }

    /**
     * @return List<User>
     */
    public List<User> getAll(){
        logger.debug("getAll");
        return userDAO.getAll();
    }


    public void add(final User user){
        logger.debug("add " + user);
        userDAO.add(user);
    }



    /*
    public void update(final User user){
        logger.debug("add " + user);
        User oldUser = this.users.get(user.getId());

        this.users.put(user.getId(),user);
    }*/


    public User get(String id){
        logger.debug("get " + id);

        try {
            return userDAO.get(id);
        } catch (UserIsNotFound userIsNotFound) {
            logger.error(String.valueOf(userIsNotFound));
            return null;
        }
    }


    public void delete(String id){
        logger.debug("getInstance: " + id);
        userDAO.delete(id);
    }


    public User login(String login, String password){

        logger.debug("login: login " + login + "password " + password);
        try {
            return userDAO.userLogin(login,password);
        } catch (UserIsNotFound userIsNotFound) {
            logger.error(String.valueOf(userIsNotFound));
            return null;
        }
    }
}
