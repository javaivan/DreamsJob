package com.ivanmix.servlets;

import com.ivanmix.service.UserService;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ivan on 09.05.2016.
 */
public class UserAllServletTest {
/*
    @Test
    @Ignore
    public void deleteUser() throws Exception {


        UserAllServlet servlet = new UserAllServlet();

        Integer numberUsers = UserService.getInstance().getAll().size();
        numberUsers --;

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("/WEB-INF/views/userAll.jsp")).thenReturn(dispatcher);

        when(request.getParameter("id")).thenReturn("1");
        servlet.doPost(request, response);

        assertEquals(numberUsers.toString(),UserService.getInstance().getAll().size()+"");

    }*/

}