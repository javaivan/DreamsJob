package com.ivanmix.servlets.item.user;

import com.ivanmix.service.ItemService;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ivan on 09.05.2016.
 */
public class ItemAddServletTest {

    @Test
    public void addItem() throws ServletException, IOException {
        Integer nubmerItem = ItemService.getInstance().getItemAll().size();
        nubmerItem++;

        ItemAddServlet servlet = new ItemAddServlet();
        HttpSession httpSession = mock(HttpSession.class);

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/item/public/list.jsp")).thenReturn(dispatcher);

        when(request.getParameter("name")).thenReturn("name22");
        when(request.getParameter("description")).thenReturn("description22");

        when(request.getSession()).thenReturn(httpSession);
        when(httpSession.getAttribute("userId")).thenReturn("1");

        servlet.doPost(request, response);

        assertEquals(nubmerItem.toString(),ItemService.getInstance().getItemAll().size()+"");
    }
}