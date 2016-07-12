package com.ivanmix.servlets;

import com.ivanmix.entity.Account;
import com.ivanmix.model.User;
import com.ivanmix.service.AccountService;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(LoginServlet.class);

    private AccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(Integer.MAX_VALUE);

        synchronized (session) {
            logger.debug("doPost: synchronized");
            Account account = accountService.getAccountByLoginAndPassword(login, password);
            if(account!=null){
                logger.debug("doPost: synchronized: " + account);
                session.setAttribute("userId", account.getId());
                session.setAttribute("login", account.getLogin());
                session.setAttribute("password", account.getPassword());
                session.setAttribute("role", account.getRole());
                resp.sendRedirect(String.format("%s/application-all", req.getContextPath()));
            } else {
                logger.debug("doPost: synchronized: user == null");
                req.setAttribute("eroor_login","Invalid login password credentionals");
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
            }
        }
    }
}
