package com.ivanmix.servlets.item;

import com.ivanmix.service.ItemService;
import com.ivanmix.servlets.LogoutServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemPublicListServlet extends HttpServlet{
    private static final Logger logger = Logger.getLogger(ItemPublicListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        req.setAttribute("items",ItemService.getInstance().getItemFirstLevel());
        req.getRequestDispatcher("/WEB-INF/views/itemPublicList.jsp").forward(req,resp);
    }
}
