package com.ivanmix.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session == null || session.getAttribute("login") == null){
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        } else {
            resp.sendRedirect(String.format("%s/item-public", req.getContextPath()));
        }
    }
}
