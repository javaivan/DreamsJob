package com.ivanmix.servlets.item.user;

import com.ivanmix.model.Item;
import com.ivanmix.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ItemViewServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(ItemViewServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        String id = req.getParameter("id");
        Item item = ItemService.getInstance().get(id);
        req.setAttribute("item",item);

        req.setAttribute("items",ItemService.getInstance().getMyItems(item.getUser()));
        req.getRequestDispatcher("/WEB-INF/views/item/user/view.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");

        HttpSession session= req.getSession();
        String userId = (String) session.getAttribute("userId");

        String itemId = req.getParameter("itemId");
        String parent = req.getParameter("parent");
        String name = req.getParameter("name");
        String description = req.getParameter("description");


        synchronized (session) {
            ItemService.getInstance().updateItem(itemId, userId, parent, name, description);
        }

        resp.sendRedirect(String.format("%s/item-user-list", req.getContextPath()));
    }
}
