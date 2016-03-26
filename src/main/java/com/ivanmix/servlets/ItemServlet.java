package com.ivanmix.servlets;

import com.ivanmix.model.Item;
import com.ivanmix.model.Role;
import com.ivanmix.model.User;
import com.ivanmix.service.ItemService;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mix on 25.03.2016.
 */
public class ItemServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String userId = (String) req.getSession().getAttribute("userId");
        String role = (String) req.getSession().getAttribute("role");

        req.setAttribute("items",ItemService.getInstance().getAll(userId,role));

        req.getRequestDispatcher(String.format("%s/views/Item.jsp", req.getContextPath())).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        String userId = (String) req.getSession().getAttribute("userId");
        String role = (String) req.getSession().getAttribute("role");

        if (id != null && name != null && description != null) {
            Item item = new Item(id, userId, name,description);
            ItemService.getInstance().add(item);
        }

        req.setAttribute("items",ItemService.getInstance().getAll(userId,role));

        req.getRequestDispatcher(String.format("%s/views/Item.jsp", req.getContextPath())).forward(req,resp);
    }
}
