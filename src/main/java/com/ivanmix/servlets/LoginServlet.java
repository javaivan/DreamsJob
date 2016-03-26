package com.ivanmix.servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by mix on 26.03.2016.
 */
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.append("<h1><a href='/'>Dreans Jod</a></h1>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session= req.getSession();

        synchronized (session) {
            session.setAttribute("login", login);
            session.setAttribute("password", password);
        }

/*
        ServletContext context = req.getServletContext();
        synchronized (context){
            context.setAttribute("url_connection","url");
        }
*/

        resp.sendRedirect(String.format("%s/index.jsp", req.getContextPath()));
    }

}