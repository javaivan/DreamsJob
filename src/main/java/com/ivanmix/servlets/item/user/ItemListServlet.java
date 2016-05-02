package com.ivanmix.servlets.item.user;

import com.ivanmix.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ItemListServlet extends HttpServlet{
    private static final Logger logger =
            LoggerFactory.getLogger(ItemListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        req.setAttribute("items",ItemService.getInstance().getMyItems(userId));
        req.getRequestDispatcher("/WEB-INF/views/item/user/list.jsp").forward(req,resp);
    }

}
