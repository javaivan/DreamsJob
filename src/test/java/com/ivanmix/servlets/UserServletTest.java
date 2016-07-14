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
public class UserServletTest {


    /*
    @Test
    @Ignore
    public void updateUser() throws ServletException, IOException {

        UserServlet servlet = new UserServlet();

        String oldName = UserService.getInstance().get("3").getLogin();
        String oldPassword = UserService.getInstance().get("3").getPassword();


        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher("/WEB-INF/views/userView.jsp")).thenReturn(dispatcher);

        when(request.getParameter("id")).thenReturn("3");
        when(request.getParameter("name")).thenReturn(oldName+"3");
        when(request.getParameter("password")).thenReturn(oldPassword+"3");

        servlet.doPost(request, response);

        assertEquals(oldName+"3",UserService.getInstance().get("3").getLogin());
        assertEquals(oldPassword+"3",UserService.getInstance().get("3").getPassword());
    }

*/


}