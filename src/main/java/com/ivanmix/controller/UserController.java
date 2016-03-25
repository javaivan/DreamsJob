package com.ivanmix.controller;


import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
        writer.append("Age: <input type=\"text\" name=\"age\" />");
        writer.append("Height: <input type=\"text\" name=\"height\" />");
        writer.append("Date Birth: <input type=\"text\" name=\"dateBirth\" value=\"14/03/2016\" />");
        writer.append("<input type=\"submit\" value=\"Submit\" />");
        writer.append("</form>");

        writer.flush();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*    resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"));
        float height = Float.parseFloat(req.getParameter("height"));

        String dateBirth = req.getParameter("dateBirth");

        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
        Date dateObj = null;
        try {
            dateObj = curFormater.parse(dateBirth);
        } catch (ParseException e) {
            //
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateObj);

        //System.out.println(cal);
        User user = new User(age, height, calendar, name);
        userService.setUser(user.getId(), user);
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.write(String.format("<h2>Successfully adding a user: %s</h2>", name));
        writer.flush();
*/
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        userService.deleteUserById(id);
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.write(String.format("<h2>User DELETE</h2>"));
        writer.flush();*/
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        User user = userService.getUserById(id);
        user.setName(name);
        userService.updateUser(user);
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.write(String.format("<h2>User Update</h2>"));
        writer.flush();*/
    }
}
