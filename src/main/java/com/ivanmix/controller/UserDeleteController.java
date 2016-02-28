package com.ivanmix.controller;


import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by mix on 24.02.2016.
 */


public class UserDeleteController extends HttpServlet {

    UserService userService = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUserById(id);
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.write(String.format("<h2>User DELETE</h2>"));
        writer.flush();
    }

}