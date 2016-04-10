package com.ivanmix.servlets.item;

import com.ivanmix.model.Item;
import com.ivanmix.model.User;
import com.ivanmix.service.ItemService;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by mix on 25.03.2016.
 */
public class ItemPublicViewServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String id = req.getParameter("id");

        Item item = ItemService.getInstance().get(id);
        req.setAttribute("id",item.getId());
        req.setAttribute("userId",item.getUserId());
        req.setAttribute("name",item.getName());
        req.setAttribute("description",item.getDescription());
        req.setAttribute("creating",item.getCreating());
        req.setAttribute("listItems",item.getListItems());


        req.setAttribute("items",ItemService.getInstance().getItemAll(item.getListItems()));
        req.getRequestDispatcher("/WEB-INF/views/itemPublicView.jsp").forward(req,resp);
    }

}
