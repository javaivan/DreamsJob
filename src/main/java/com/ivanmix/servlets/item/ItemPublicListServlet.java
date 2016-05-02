package com.ivanmix.servlets.item;

import com.ivanmix.service.ItemService;
import com.ivanmix.servlets.LogoutServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemPublicListServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(ItemPublicListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        req.setAttribute("items",ItemService.getInstance().getItemFirstLevel());
        req.getRequestDispatcher("/WEB-INF/views/item/public/list.jsp").forward(req,resp);
    }
}
