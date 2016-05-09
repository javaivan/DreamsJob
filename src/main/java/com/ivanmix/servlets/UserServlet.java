package com.ivanmix.servlets;

import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import com.ivanmix.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(UserServlet.class);

/*    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        String id = req.getParameter("id");
        User user = UserService.getInstance().get(id);

        req.setAttribute("userId",user.getId());
        req.setAttribute("userLogin",user.getLogin());
        req.setAttribute("userPassword",user.getPassword());
        req.getRequestDispatcher(String.format("%s/views/userView.jsp", req.getContextPath())).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        if (id != null && name != null) {
            UserService.getInstance().add(new User(id, name, password, new Role("USER")));
        }
        req.getRequestDispatcher("/WEB-INF/views/userView.jsp").forward(req,resp);
    }*/
}
