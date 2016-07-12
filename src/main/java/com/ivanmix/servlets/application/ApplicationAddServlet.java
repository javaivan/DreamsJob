package com.ivanmix.servlets.application;

import com.ivanmix.entity.Application;
import com.ivanmix.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

public class ApplicationAddServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationAddServlet.class);

    private ApplicationService applicationService = new ApplicationService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("doGet");
        request.setAttribute("applications", applicationService.getCildren(0));
        request.getRequestDispatcher(String.format("/WEB-INF/views/application/add.jsp", request.getContextPath()))
                .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int parent = Integer.parseInt(req.getParameter("parent"));

        logger.debug("doPost: title: " + title );
        logger.debug("doPost: description: " + description );
        logger.debug("doPost: parent: " + parent );

        if (title != null && description != null) {
            Application application = new Application();
            application.setTitle(title);
            application.setDescription(description);
            application.setParent(parent);

            Calendar cl = Calendar.getInstance();
            application.setCreated(new Date(cl.getTimeInMillis()));
            applicationService.addApplication(application);
        }
        resp.sendRedirect(String.format("%s/application-all", req.getContextPath()));
    }
}
