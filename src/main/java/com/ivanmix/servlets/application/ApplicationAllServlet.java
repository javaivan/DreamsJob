package com.ivanmix.servlets.application;

import com.ivanmix.entity.Application;
import com.ivanmix.service.ApplicationService;
import com.ivanmix.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ApplicationAllServlet extends HttpServlet {
    private static final Logger logger =
            LoggerFactory.getLogger(ApplicationAllServlet.class);

    private static ApplicationService applicationService = new ApplicationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doGet");
        List<Application> applications = applicationService.getAllApplication();
        req.setAttribute("applications", applications);
        req.getRequestDispatcher("/WEB-INF/views/application/list.jsp").forward(req,resp);
    }
}
