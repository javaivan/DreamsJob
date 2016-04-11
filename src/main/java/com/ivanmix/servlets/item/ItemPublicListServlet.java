package com.ivanmix.servlets.item;

import com.ivanmix.service.ItemService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemPublicListServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("items",ItemService.getInstance().getPublicItem());
        req.getRequestDispatcher("/WEB-INF/views/itemPublicList.jsp").forward(req,resp);
    }
}
