package com.ivanmix.servlets;

import com.ivanmix.model.Item;
import com.ivanmix.model.User;
import com.ivanmix.service.ItemService;
import com.ivanmix.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mix on 25.03.2016.
 */
public class ItemViewServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{


        /*
        Cookie cookie = new Cookie("url","mkyong dot com");
        cookie.setMaxAge(60*60); //1 hour
        resp.addCookie(cookie);


        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cookieName")) {
                    //do something
                    //value can be retrieved using #cookie.getValue()
                }
            }
        }*/


        String id = req.getParameter("id");
        String userId = (String) req.getSession().getAttribute("userId");
        String role = (String) req.getSession().getAttribute("role");

        Item item = ItemService.getInstance().get(id);
        req.setAttribute("id",item.getId());
        req.setAttribute("userId",item.getUserId());
        req.setAttribute("name",item.getName());
        req.setAttribute("description",item.getDescription());


        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("item"+id)) {
                    List<String> list = new ArrayList<String>(Arrays.asList(cookie.getValue().split(",")));
                    list.remove(" ");
                    req.setAttribute("items",ItemService.getInstance().getItemAll(list));
                }
            }
        }

        req.getRequestDispatcher("/WEB-INF/views/itemView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        String[] items = req.getParameterValues("item");

        if (req.getParameterMap().containsKey("submit")) {

            List<String> selectedItems = new ArrayList<String>();

            for (String s : items) {
                selectedItems.add(s);
            }

            List<String> sriList = null;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("selectedItems")) {
                        String s = cookie.getValue();
                        sriList  = new ArrayList<String>(Arrays.asList(cookie.getValue().split(",")));
                    }
                }
            }
            if(sriList!=null) {
                for (String it : sriList) {
                    if (!Arrays.asList(sriList).contains(it)) {
                        selectedItems.add(it);
                    }
                }
            }

            Cookie cookie = new Cookie("selectedItems",selectedItems.toString().replaceAll("\\[|\\]|\\s", ""));
            resp.addCookie(cookie);

        }

        if (req.getParameterMap().containsKey("delete")) {

            String id = req.getParameter("id");
            List<String> itemList = null;

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("item"+id)) {
                        itemList  = new ArrayList<String>(Arrays.asList(cookie.getValue().split(",")));
                    }
                }
            }
            if(itemList!=null) {
                for (String it : items) {
                    itemList.remove(it.trim());
                }
            }

            Cookie cookie = new Cookie("item"+id,itemList.toString().replaceAll("\\[|\\]|\\s", ""));



            resp.addCookie(cookie);
        }

        if (req.getParameterMap().containsKey("insert")) {

            String id = req.getParameter("id");
            List<String> itemList = null;

            List<String> selectedItems = new ArrayList<String>();



            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("selectedItems")) {
                        selectedItems  = new ArrayList<String>(Arrays.asList(cookie.getValue().split(",")));
                    }
                }
            }

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("item"+id)) {
                        itemList  = new ArrayList<String>(Arrays.asList(cookie.getValue().split(",")));
                    }
                }
            }
            if(itemList!=null) {
                for (String it : itemList) {
                    if (!Arrays.asList(itemList).contains(it)) {
                        selectedItems.add(it);
                    }
                }
            }

            System.out.println(selectedItems.toString());

            Cookie cookie = new Cookie("selectedItems",null);
            resp.addCookie(cookie);

            Cookie cookieItems = new Cookie("item"+id,selectedItems.toString().replaceAll("\\[|\\]|\\s", ""));
            resp.addCookie(cookieItems);
        }

        resp.sendRedirect(String.format("%s/item", req.getContextPath()));
    }
}
