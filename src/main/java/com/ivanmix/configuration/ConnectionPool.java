package com.ivanmix.configuration;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ivan on 23.05.2016.
 */
public class ConnectionPool {

    private static BasicDataSource connectionPool;

    public static BasicDataSource connection(){
        String dbUrl = "jdbc:postgresql://localhost:5432/dreams_job";
        connectionPool = new BasicDataSource();

        connectionPool.setUsername("dreams_job");
        connectionPool.setPassword("dreams_job");

        connectionPool.setDriverClassName("org.postgresql.Driver");
        connectionPool.setUrl(dbUrl);
        connectionPool.setInitialSize(10);

        return connectionPool;
    }


    public BasicDataSource getConnection() {
        return connectionPool;
    }
}
