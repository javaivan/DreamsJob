package com.ivanmix.servlets;

import com.ivanmix.model.Item;
import com.ivanmix.model.User;
import com.ivanmix.service.ItemService;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mix on 25.03.2016.
 */
public class ItemViewServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        HttpSession session= req.getSession();

        String id = req.getParameter("id");
        String userId = (String) req.getSession().getAttribute("userId");
        String role = (String) req.getSession().getAttribute("role");

        Item item = ItemService.getInstance().get(id);
        req.setAttribute("id",item.getId());
        req.setAttribute("userId",item.getUserId());
        req.setAttribute("name",item.getName());
        req.setAttribute("description",item.getDescription());

        synchronized (session) {
            if(session.getAttribute("item"+id)!=null){
                ArrayList<String> itemList = (ArrayList)session.getAttribute("item"+id);
                req.setAttribute("items",ItemService.getInstance().getItemAll(itemList));
            }
        }
        req.getRequestDispatcher(String.format("%s/views/ItemView.jsp", req.getContextPath())).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session= req.getSession();
        String[] items = req.getParameterValues("item");

        if (req.getParameterMap().containsKey("submit")) {
            synchronized (session) {
                ArrayList<String> selectedItems = new ArrayList<String>();
                for (String s : items) {
                    selectedItems.add(s);
                }
                if(session.getAttribute("selectedItems")!=null){
                    ArrayList<String> sriList = (ArrayList)session.getAttribute("selectedItems");
                    for (String it : sriList){
                        if (!Arrays.asList(sriList).contains(it)) {
                            selectedItems.add(it);
                        }
                    }
                }
                session.setAttribute("selectedItems", selectedItems);
            }
        }

        if (req.getParameterMap().containsKey("delete")) {
            synchronized (session) {
                String id = req.getParameter("id");

                if(session.getAttribute("item"+id)!=null){
                    ArrayList<String> itemList = (ArrayList)session.getAttribute("item"+id);

                    for (String it : items){
                        itemList.remove(it);
                    }
                    session.setAttribute("item"+id, itemList);
                }
            }
        }

        if (req.getParameterMap().containsKey("insert")) {
            synchronized (session) {
                String id = req.getParameter("id");
                ArrayList<String> selectedItems = new ArrayList<String>();
                if(session.getAttribute("selectedItems")!=null){
                    ArrayList<String> sriList = (ArrayList)session.getAttribute("selectedItems");
                    for (String it : sriList){
                        if (!Arrays.asList(sriList).contains(it)) {
                            selectedItems.add(it);
                        }
                    }
                }
                session.setAttribute("item"+id, selectedItems);
                session.setAttribute("selectedItems", null);
            }
        }

        resp.sendRedirect(String.format("%s/item", req.getContextPath()));
    }
}
