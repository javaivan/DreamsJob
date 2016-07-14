package com.ivanmix.dao;


import com.ivanmix.configuration.ConnectionPool;
import com.ivanmix.configuration.HibernateUtil;
import com.ivanmix.entity.Account;
import com.ivanmix.exception.UserIsNotFound;
import com.ivanmix.entity.User;
import com.ivanmix.service.ItemService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final Logger logger =
            LoggerFactory.getLogger(UserDAO.class);


    private static SessionFactory factory  = HibernateUtil.getSessionFactory();

    public int addUser(User user){
        Integer  id;
        logger.debug("addUser: " + user);
        try (Session session = factory.openSession()){
            session.getTransaction().begin();
            id  = (Integer) session.save(user);
            session.getTransaction().commit();
            return id;
        }
    }

    public User getUserById(int id){
        logger.debug("getUserById: " + id);
        try (Session session = factory.openSession()){
            return session.get(User.class, id);
        }
    }

    public User getUserByLoginAndPassword(String login, String password){
        logger.debug("getUserByLoginAndPassword: " + login + " || " + password );
        try (Session session = factory.openSession()){
            String hql = "FROM User u WHERE u.login = :login and u.password = :password";
            Query query = session.createQuery(hql);
            query.setString("login", login);
            query.setString("password", password);
            return (User)query.uniqueResult();
        }
    }

    public void updateUser(User user){
        logger.debug("updateUser: " + user);
        try (Session session = factory.openSession()){
            session.getTransaction().begin();
            session.update(user);
            session.getTransaction().commit();
        }
    }

    public List<User> getAllUser(){
        logger.debug("getAllUser");
        try (Session session = factory.openSession()){
            return session.createQuery("from User").list();
        }
    }






    public Account getAccountById(int id){
        logger.debug("getAccountById: " + id);
        try (Session session = factory.openSession()){
            //session.getTransaction();
            return session.get(Account.class,id);
        }
    }

    public Account getAccountByLoginAndPassword(String login, String password){
        logger.debug("getAccountByLoginAndPassword: " + login + " | "+ password);
        try (Session session = factory.openSession()){
            //session.getTransaction();
            String hql = "FROM Account a WHERE a.login = :login and a.password = :password";
            Query query = session.createQuery(hql);
            query.setParameter("login", login);
            query.setParameter("password", password);
            return (Account)query.uniqueResult();
        }
    }

    public void addAccount(Account account){
        logger.debug("addAccount: " + account);
        try (Session session = factory.openSession()){
            //session.getTransaction();
            session.save(account);
        }
    }

    public void updateAccount(Account account){
        logger.debug("updateAccount: " + account);
        try (Session session = factory.openSession()){
            //session.getTransaction();
            session.update(account);
        }
    }

    public List<Account> getAllAccount(){
        logger.debug("getAllAccount");
        try (Session session = factory.openSession()){
            //session.getTransaction();
            return session.createQuery("from Account").list();
        }
    }




}
