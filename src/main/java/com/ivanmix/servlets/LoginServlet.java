package com.ivanmix.servlets;

import com.ivanmix.model.User;
import com.ivanmix.service.UserService;

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
        session.setMaxInactiveInterval(Integer.MAX_VALUE);

        synchronized (session) {
            User user = UserService.getInstance().login(login,password);
            if(user!=null){
                session.setAttribute("userId", user.getId());
                session.setAttribute("login", user.getLogin());
                session.setAttribute("password", user.getPassword());
                session.setAttribute("role", user.getRole());
                req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
            } else {
                req.setAttribute("eroor.login","Invalid login password credentionals");
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
            }
        }
    }
}
