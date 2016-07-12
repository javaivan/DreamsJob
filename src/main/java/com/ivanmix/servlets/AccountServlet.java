package com.ivanmix.servlets;

import com.ivanmix.entity.Account;
import com.ivanmix.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(AccountServlet.class);

    private AccountService accountService = new AccountService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("doGet");
        int id = Integer.parseInt(request.getParameter("id"));
        Account account = accountService.getAccountById(id);
        request.setAttribute("account", account);
        request.getRequestDispatcher(String.format("/WEB-INF/views/accountView.jsp", request.getContextPath()))
                .forward(request, response);
    }
}
