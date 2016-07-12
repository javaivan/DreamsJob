package com.ivanmix.servlets.application;

import com.ivanmix.entity.Account;
import com.ivanmix.entity.Application;
import com.ivanmix.service.AccountService;
import com.ivanmix.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationServlet.class);

    private ApplicationService applicationService = new ApplicationService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("doGet");
        int id = Integer.parseInt(request.getParameter("id"));
        Application application = applicationService.getApplicationById(id);
        request.setAttribute("application", application);
        request.getRequestDispatcher(String.format("/WEB-INF/views/application/view.jsp", request.getContextPath()))
                .forward(request, response);
    }


}
