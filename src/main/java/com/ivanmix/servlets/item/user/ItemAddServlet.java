package com.ivanmix.servlets.item.user;

import com.ivanmix.model.Item;
import com.ivanmix.service.ItemService;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

public class ItemAddServlet extends HttpServlet{
    private static final Logger logger = Logger.getLogger(ItemAddServlet.class);

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

        if (name != null && description != null && userId != null) {
            HashSet<String> listItems = new HashSet<String>();
            Item item = new Item("new",userId, "0", name,description, new Date(), listItems);
            logger.debug("doPost: " + item );
            ItemService.getInstance().add(item);
        }
        resp.sendRedirect(String.format("%s/item-user-list", req.getContextPath()));
    }
}
