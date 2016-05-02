package com.ivanmix.servlets;

import com.ivanmix.service.UserService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAllServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(UserAllServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doGet");

        req.setAttribute("users",UserService.getInstance().getAll());
        req.getRequestDispatcher("/WEB-INF/views/userAll.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        String id = req.getParameter("id");
        UserService.getInstance().delete(id);

        req.setAttribute("users",UserService.getInstance().getAll());
        req.getRequestDispatcher("/WEB-INF/views/userAll.jsp").forward(req,resp);
    }
}
