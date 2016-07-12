package com.ivanmix.dao;

import com.ivanmix.configuration.HibernateUtil;
import com.ivanmix.entity.Application;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ApplicationDAO {
    private static final Logger logger =
            LoggerFactory.getLogger(ApplicationDAO.class);

    private static SessionFactory factory  = HibernateUtil.getSessionFactory();

    public Application getApplicationById(int id){
        logger.debug("getApplicationById: " + id);
        try(Session session = factory.openSession()){
            session.getTransaction();
            return session.get(Application.class, id);
        }
    }

    public void addApplication(Application application){
        logger.debug("addApplication: " + application);
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.save(application);
        }
    }

    public void updateApplication(Application application){
        logger.debug("updateApplication: " + application);
        try (Session session = factory.openSession()){
            session.getTransaction().begin();
            session.update(application);
            session.getTransaction().commit();
        }
    }

    public void deleteApplication(Application application){
        logger.debug("deleteApplication: " + application);
        try (Session session = factory.openSession()){
            session.getTransaction();
            session.delete(application);
        }
    }

    public List<Application> getAllApplication(){
        logger.debug("getAllApplication");
        try (Session session = factory.openSession()){
            session.getTransaction();
            List<Application> applications = session.createQuery("from Application").list();
            return applications;
        }
    }

    public List<Application> getCildren(int id){
        logger.debug("getCildren: " + id);
        try (Session session = factory.openSession()){
            session.getTransaction();
            String hql = "FROM Application a WHERE a.parent = :parent";
            Query query = session.createQuery(hql);
            query.setParameter("parent", id);
            List<Application> applications = query.list();
            return applications;
        }
    }
}
