package com.ivanmix.servlets;

import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mix on 25.03.2016.
 */
public class UserAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",UserService.getInstance().getAll());
        req.getRequestDispatcher(String.format("%s/views/UserAll.jsp", req.getContextPath())).forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        UserService.getInstance().deleted(id);
        req.setAttribute("users",UserService.getInstance().getAll());
        req.getRequestDispatcher(String.format("%s/views/UserAll.jsp", req.getContextPath())).forward(req,resp);
    }

}
