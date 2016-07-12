package com.ivanmix.service;

import com.ivanmix.dao.UserDAO;
import com.ivanmix.entity.Account;
import com.ivanmix.exception.UserIsNotFound;
import com.ivanmix.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AccountService {
    private static final Logger logger =
            LoggerFactory.getLogger(AccountService.class);

    private static UserDAO userDAO = new UserDAO();

    public List<Account> getAllAccount(){
        logger.debug("getAllAccount");
        return userDAO.getAllAccount();
    }

    public void addAccount(Account account){
        logger.debug("addAccount: " + account);
        userDAO.addAccount(account);
    }

    public Account getAccountById(int id){
        logger.debug("getAccountById: " + id);
        return userDAO.getAccountById(id);
    }

    public Account getAccountByLoginAndPassword(String login, String password){
        logger.debug("getAccountByLoginAndPassword: " + login + " | " + password);
        return userDAO.getAccountByLoginAndPassword(login, password);
    }
}
