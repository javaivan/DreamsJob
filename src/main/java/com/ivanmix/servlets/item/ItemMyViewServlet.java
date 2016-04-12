package com.ivanmix.servlets.item;

import com.ivanmix.model.Item;
import com.ivanmix.service.ItemService;
import com.ivanmix.servlets.LogoutServlet;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ItemMyViewServlet extends HttpServlet{
    private static final Logger logger = Logger.getLogger(ItemMyViewServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        String id = req.getParameter("id");
        Item item = ItemService.getInstance().get(id);

        req.setAttribute("id",item.getId());
        req.setAttribute("userId",item.getUserId());
        req.setAttribute("name",item.getName());
        req.setAttribute("description",item.getDescription());
        req.setAttribute("creating",item.getCreating());
        req.setAttribute("listItems",item.getListItems());
        req.setAttribute("items",ItemService.getInstance().getItemAll(item.getListItems()));
        req.getRequestDispatcher("/WEB-INF/views/itemMyView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        HttpSession session= req.getSession();
        String userId = (String) req.getSession().getAttribute("userId");
        String[] reqItems = req.getParameterValues("item");
        String itemId = req.getParameter("id");
        List<String> listItems = new ArrayList<String>();

        if (req.getParameterMap().containsKey("insert")) {
            logger.debug("doPost: insert");
            synchronized (session) {
                if(session.getAttribute("sessionItems")!=null){
                    listItems = (ArrayList)session.getAttribute("sessionItems");
                }
                ItemService.getInstance().addItems(itemId, listItems);
                session.setAttribute("sessionItems", null);
            }
        }
        if (req.getParameterMap().containsKey("delete")) {
            logger.debug("doPost: delete");
            synchronized (session) {
                ItemService.getInstance().removeItemsInItem(itemId, reqItems);
            }
        }
        resp.sendRedirect(String.format("%s/item-my", req.getContextPath()));
    }
}
