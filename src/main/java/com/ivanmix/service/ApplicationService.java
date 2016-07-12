package com.ivanmix.service;

import com.ivanmix.dao.ApplicationDAO;
import com.ivanmix.entity.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.jar.Attributes;

public class ApplicationService {
    private static final Logger logger =
            LoggerFactory.getLogger(AccountService.class);

    private static ApplicationDAO applicationDAO = new ApplicationDAO();

    public Application getApplicationById(int id){
        logger.debug("getApplicationById: " + id);
        return applicationDAO.getApplicationById(id);
    }

    public void addApplication(Application application){
        logger.debug("addApplication: " + application);
        applicationDAO.addApplication(application);
    }

    public void updateApplication(Application application){
        logger.debug("updateApplication: " + application);
        Application app = applicationDAO.getApplicationById(application.getId());
        app.setTitle(application.getTitle());
        app.setDescription(application.getDescription());
        app.setParent(application.getParent());
        applicationDAO.updateApplication(app);
    }

    public void deleteApplication(Application application){
        logger.debug("deleteApplication: " + application);
        applicationDAO.deleteApplication(application);
    }

    public List<Application> getAllApplication(){
        logger.debug("getAllApplication");
        List<Application> applications =  applicationDAO.getAllApplication();
        return applications;
    }

    public List<Application> getCildren(int id){
        logger.debug("getCildren: " + id);
        List<Application> applications =  applicationDAO.getCildren(id);
        return applications;
    }
}
