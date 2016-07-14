package com.ivanmix.servlets;

import com.ivanmix.service.UserService;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by ivan on 09.05.2016.
 */
public class LoginServletTest {
/*
    @Test
    @Ignore
    public void loginUser() throws ServletException, IOException {
        LoginServlet servlet = new LoginServlet();
        UserService userService = mock(UserService.class);

        HttpSession httpSession = mock(HttpSession.class);
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/login.jsp")).thenReturn(dispatcher);

        when(request.getParameter("login")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("admin");


        when(request.getSession()).thenReturn(httpSession);


        servlet.doPost(request, response);

        request.getSession().getAttribute()


        verify(userService, atLeastOnce()).getInstance().getAll();

    }*/
}