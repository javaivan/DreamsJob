package com.ivanmix.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doGet");
        req.getSession().invalidate();
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }
}
