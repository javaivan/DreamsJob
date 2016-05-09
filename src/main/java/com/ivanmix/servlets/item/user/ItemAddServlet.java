package com.ivanmix.servlets.item.user;

import com.ivanmix.model.Item;
import com.ivanmix.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

public class ItemAddServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(ItemAddServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");

        req.getRequestDispatcher("/WEB-INF/views/item/user/add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String userId = (String) req.getSession().getAttribute("userId");
        logger.debug("doPost: name: " + name );
        logger.debug("doPost: description: " + description );
        logger.debug("doPost: userId: " + userId );

        if (name != null && description != null && userId != null) {
            HashSet<String> listItems = new HashSet<String>();
            Item item = new Item("new",userId, "0", name,description, new Date(), listItems);
            logger.debug("doPost: " + item );
            ItemService.getInstance().add(item);
        }
        resp.sendRedirect(String.format("%s/item-user-list", req.getContextPath()));
    }
}
