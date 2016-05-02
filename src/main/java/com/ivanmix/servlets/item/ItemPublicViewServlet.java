package com.ivanmix.servlets.item;

import com.ivanmix.model.Item;
import com.ivanmix.service.ItemService;
import com.ivanmix.servlets.LogoutServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class ItemPublicViewServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(ItemPublicViewServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");

        String id = req.getParameter("id");
        Item item = ItemService.getInstance().get(id);

        req.setAttribute("item",item);
        req.setAttribute("items",ItemService.getInstance().getItemAll(item.getChildren()));
        req.getRequestDispatcher("/WEB-INF/views/item/public/view.jsp").forward(req,resp);
    }
}
