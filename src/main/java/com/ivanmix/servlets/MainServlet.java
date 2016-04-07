package com.ivanmix.servlets;

import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by mix on 07.04.2016.
 */
public class MainServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);

        HttpSession session = req.getSession();

        if(session == null || session.getAttribute("login") == null){
            //req.getRequestDispatcher(String.format("%s/views/login.jsp", req.getContextPath())).forward(req,resp);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        } else {
            //req.getRequestDispatcher(String.format("%s/views/index.jsp", req.getContextPath())).forward(req,resp);
            req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
        }

    }
}
