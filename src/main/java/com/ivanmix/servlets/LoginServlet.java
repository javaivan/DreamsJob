package com.ivanmix.servlets;

import com.ivanmix.model.User;
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
/**
 * Created by mix on 26.03.2016.
 */
public class LoginServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(LoginServlet.class);

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
        HttpSession session= req.getSession();
        session.setMaxInactiveInterval(Integer.MAX_VALUE);

        synchronized (session) {
            logger.debug("doPost: synchronized");
            User user = UserService.getInstance().login(login,password);
            if(user!=null){
                logger.debug("doPost: synchronized: " + user);
                session.setAttribute("userId", user.getId());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("password", user.getPassword());
                session.setAttribute("role", user.getRole());
                resp.sendRedirect(String.format("%s/item-public-list", req.getContextPath()));
            } else {
                logger.debug("doPost: synchronized: user == null");
                req.setAttribute("eroor_login","Invalid login password credentionals");
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
            }
        }
    }
}
