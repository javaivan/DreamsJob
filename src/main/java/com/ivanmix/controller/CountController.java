package com.ivanmix.controller;


import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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

    private volatile int countOne;
    private int countTwo;
    private volatile int countThree;
    private int countFour;

    public void init()
    {
        countOne = 0;
        countTwo = 0;
        countThree = 0;
        countFour = 0;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        countOne++;
        countFour++;

        if(req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest)req;
            HttpServletResponse response = (HttpServletResponse)res;
            this.service(request, response);
        } else {
            throw new ServletException("non-HTTP request or response");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        synchronized( this ) {
            countTwo++;
        }

        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.append("<h2>countOne: " + countOne + "</h2>");
        writer.append("<h2>countTwo: " + countTwo + "</h2>");
        writer.append("<h2>countThree: " + countThree + "</h2>");
        writer.append("<h2>countFour: " + countFour + "</h2>");
        resp.setContentType("text/html");
        writer.append("<form action=\"/count\" method=\"POST\">");
        writer.append("<input type=\"submit\" value=\"Submit\" />");
        writer.append("</form>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        countThree++;
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.append("<h2>countOne: " + countOne + "</h2>");
        writer.append("<h2>countTwo: " + countTwo + "</h2>");
        writer.append("<h2>countThree: " + countThree + "</h2>");
        writer.append("<h2>countFour: " + countFour + "</h2>");
        writer.flush();
    }

}
