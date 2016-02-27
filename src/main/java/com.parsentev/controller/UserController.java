package com.parsentev.controller;


import com.parsentev.model.User;
import com.parsentev.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by mix on 24.02.2016.
 */


public class UserController extends HttpServlet{

    UserService userService = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.append("<h2>Add User</h2>");
        writer.append("<form action=\"\" method=\"POST\">");
        writer.append("Name: <input type=\"text\" name=\"name\" />");
        writer.append("<input type=\"submit\" value=\"Submit\" />");
        writer.append("</form>");

        writer.flush();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        String name = req.getParameter("name");
        User user = new User(name);
        userService.setUser(user.getId(), user);
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.write(String.format("<h2>Successfully adding a user: %s</h2>", name));
        writer.flush();

    }

/*   protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       resp.getWriter().write(String.format("<h1>User Put"));

    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUserById(id);
        resp.getWriter().write(String.format("<h1>User DELETE"));
    }*/
}
