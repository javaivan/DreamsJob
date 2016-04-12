package com.ivanmix.servlets.item;

import com.ivanmix.model.Item;
import com.ivanmix.service.ItemService;
import com.ivanmix.servlets.LogoutServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

public class ItemServlet extends HttpServlet{
    private static final Logger logger = Logger.getLogger(ItemServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        resp.sendRedirect(String.format("%s/item-my", req.getContextPath()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String userId = (String) req.getSession().getAttribute("userId");

        if (name != null && description != null && userId != null) {
            LinkedList<String> listItems = new LinkedList<String>();
            Item item = new Item("new",userId, name,description, new Date(), listItems);
            logger.debug("doPost: " + item );
            ItemService.getInstance().add(item);
        }
        resp.sendRedirect(String.format("%s/item-my", req.getContextPath()));
    }
}
