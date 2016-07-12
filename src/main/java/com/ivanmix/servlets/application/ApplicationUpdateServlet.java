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

public class ApplicationUpdateServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationUpdateServlet.class);

    private ApplicationService applicationService = new ApplicationService();


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.debug("doGet");
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("application", applicationService.getApplicationById(id));
        request.setAttribute("applications", applicationService.getCildren(0));
        request.getRequestDispatcher(String.format("/WEB-INF/views/application/update.jsp", request.getContextPath()))
                .forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("doPost");
        int id = Integer.parseInt(req.getParameter("id"));
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int parent = Integer.parseInt(req.getParameter("parent"));

        logger.debug("doPost: id: " + id );
        logger.debug("doPost: title: " + title );
        logger.debug("doPost: description: " + description );
        logger.debug("doPost: parent: " + parent );

        Application application = new Application();
        application.setId(id);
        application.setTitle(title);
        application.setDescription(description);
        application.setParent(parent);

        applicationService.updateApplication(application);
        resp.sendRedirect(String.format("%s/application-all", req.getContextPath()));
    }
}
