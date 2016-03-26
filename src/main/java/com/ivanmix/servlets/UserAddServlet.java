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
public class UserAddServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("name","value");
        req.getRequestDispatcher(String.format("%s/views/UserAdd.jsp", req.getContextPath())).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        if (id != null && name != null) {
            UserService.getInstance().add(new User(id, name));
        }
        resp.sendRedirect(String.format("%s/user-all", req.getContextPath()));
    }
}