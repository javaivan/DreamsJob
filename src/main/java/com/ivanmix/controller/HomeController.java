package com.ivanmix.controller;


import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by mix on 24.02.2016.
 */


public class HomeController extends HttpServlet{

    UserService userService = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
/*
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.append("<h2>All User</h2>");
        writer.append("<h3><a href='/user'>Add new User</a></h3>");
        writer.append("<h3><a href='/count'>Count</a></h3>");
        List<User> users = userService.allUsers();
        for (User user: users){
            writer.append(user.toString());
            writer.append("<form action=\"/user-delete\" method=\"post\">");
            writer.append("<input type=\"hidden\" name=\"id\" value=\""+user.getId()+"\" />");
            writer.append("<input type=\"submit\" value=\"Delete\" />");
            writer.append("</form>");
            writer.append("<br>");
            writer.append("<form action=\"/user-update\" method=\"post\">");
            writer.append("<input type=\"hidden\" name=\"id\" value=\""+user.getId()+"\" />");
            writer.append("<input type=\"text\" name=\"name\" value=\""+user.getName()+"\" />");
            writer.append("<input type=\"submit\" value=\"Update\" />");
            writer.append("</form>");
            writer.append("<hr>");
        }
        writer.flush();*/
    }

}
