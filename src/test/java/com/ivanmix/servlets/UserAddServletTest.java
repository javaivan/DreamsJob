package com.ivanmix.servlets;

import com.ivanmix.service.UserService;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ivan on 09.05.2016.
 */
public class UserAddServletTest {
/*
    @Test
    @Ignore

    public void addNewUser() throws ServletException, IOException {
        UserAddServlet servlet = new UserAddServlet();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/userAll.jsp")).thenReturn(dispatcher);

        when(request.getParameter("id")).thenReturn("4");
        when(request.getParameter("name")).thenReturn("oleg");
        when(request.getParameter("password")).thenReturn("oleg");

        servlet.doPost(request, response);
        assertFalse(UserService.getInstance().getAll().isEmpty());
        assertEquals("oleg",UserService.getInstance().get("4").getLogin());
    }*/

}