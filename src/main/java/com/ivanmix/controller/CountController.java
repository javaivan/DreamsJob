package com.ivanmix.controller;


import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by mix on 24.02.2016.
 */


public class CountController extends HttpServlet{

    private int countTwo;
    private volatile int countOne;

    public void init()
    {
        countOne = 0;
        countTwo = 0;
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        countOne++;
        synchronized( this ) {
            countTwo++;
        }
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.append("<h2>countOne: " + countOne + "</h2>");
        writer.append("<h2>countTwo: " + countTwo + "</h2>");
        writer.flush();
    }

}
