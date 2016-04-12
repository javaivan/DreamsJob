package com.ivanmix.servlets.item;

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
import java.util.Arrays;
import java.util.List;

public class ItemMyListServlet extends HttpServlet{
    private static final Logger logger = Logger.getLogger(ItemMyListServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        logger.debug("doGet");
        HttpSession session = req.getSession();
        String userId = (String) session.getAttribute("userId");

        req.setAttribute("items",ItemService.getInstance().getMyItems(userId));
        req.getRequestDispatcher("/WEB-INF/views/itemMyList.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        HttpSession session= req.getSession();
        String userId = (String) req.getSession().getAttribute("userId");
        String[] reqItems = req.getParameterValues("item");
        List<String> listItems = new ArrayList<String>();

        if (req.getParameterMap().containsKey("selected")) {
            logger.debug("doPost: selected");
            synchronized (session) {
                for (String item : reqItems) {
                    listItems.add(item);
                }
                if(session.getAttribute("selectedItems")!=null){
                    List<String> sessionItems = (ArrayList)session.getAttribute("sessionItems");
                    for (String item : sessionItems){
                        if (!Arrays.asList(listItems).contains(item)) {
                            listItems.add(item);
                        }
                    }
                }
                session.setAttribute("sessionItems", listItems);
            }
        }
        if (req.getParameterMap().containsKey("addToPublic")) {
            logger.debug("doPost: addToPublic");
            ItemService.getInstance().addToPublic(userId, reqItems);
        }
        if (req.getParameterMap().containsKey("removeFromPublic")) {
            logger.debug("doPost: removeFromPublic");
            ItemService.getInstance().removeFromPublic(userId, reqItems);
        }
        resp.sendRedirect(String.format("%s/item-my", req.getContextPath()));
    }
}
