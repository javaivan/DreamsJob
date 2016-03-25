package com.ivanmix.servlets;

import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by mix on 25.03.2016.
 */
public class UserServlet  extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        System.out.println(name);
        if (id != null && name != null) {
            UserService.getInstance().add(new User(id, name));
        }
        resp.sendRedirect(String.format("%s/views/UserView.jsp", req.getContextPath()));
    }

}
