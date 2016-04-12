package com.ivanmix.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mix on 26.03.2016.
 */
public class LogoutServlet extends HttpServlet{
    private static final Logger logger = Logger.getLogger(LogoutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doGet");
        req.getSession().invalidate();
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }
}
