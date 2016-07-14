package com.ivanmix;

import com.ivanmix.configuration.HibernateUtil;
import com.ivanmix.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by ivan on 22.05.2016.
 * dreams_job
 * jdbc:postgresql://localhost:5432/my-resume
 */
public class Main {

    public static void main(String[] args){


        SessionFactory factory  = HibernateUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();



      /*  User user = new User();
        //user.setId("20");
       /* user.setLogin("1test");
        user.setPassword("1test");
        //session.save(user);*/

        //System.out.println(session.get(User.class,1));
        System.out.println(session.createQuery("from User").list());



        /*
        Account account = new Account();
        account.setLogin("root2");
        account.setPassword("root2");
        account.setRole("0");
        session.save(account);
        */


        ///////System.out.println(session.get(Account.class,7));
        /*
        System.out.println(session.createQuery("from Account a WHERE a.login = root");*/

/*
        String hql = "FROM Account a WHERE a.login = :login";
        Query query = session.createQuery(hql);
        query.setParameter("login","root");
        Account a = (Account)query.uniqueResult();
        System.out.println(a);*/


        /*
        List results = query.list();
        System.out.println(results);*/

        //////////////////System.out.println(session.createQuery("from Account ").list());

/*

        session.getTransaction().commit();
        session.close();
        factory.close();*/

        //      System.out.println(new UserDAO().getAccountById(7));



    }



    //public static void main(String[] args) throws SQLException {

/*
        BasicDataSource connectionPool;

        String dbUrl = "jdbc:postgresql://localhost:5432/dreams_job";
        connectionPool = new BasicDataSource();

            connectionPool.setUsername("dreams_job");
            connectionPool.setPassword("dreams_job");

        connectionPool.setDriverClassName("org.postgresql.Driver");
        connectionPool.setUrl(dbUrl);
        connectionPool.setInitialSize(1);

        Connection connection = connectionPool.getConnection();
*/
/*
        ConnectionPool n
        Statement stmt = new ConnectionPool();
*/
        //Statement stmt = connection.createStatement();
        //stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
/*
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS users (login character varying(255) NOT NULL)");


        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
        while (rs.next()) {
            System.out.println("Read from DB: " + rs.getTimestamp("tick") + "\n");
        }
*/
       // System.out.println(new UserDAO().getUser("admin"));




        /*Connection connection = ConnectionPool.connection().getConnection();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE");

        //ps.setString(1, login);

//        ResultSet resultSet = ps.executeQuery();
/*
        *
        * */




        /*

        Connection connection = ConnectionPool.connection().getConnection();

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM client WHERE login = ? AND password = ?");

        ps.setString(1,"admin");
        ps.setString(2,"admin2");
        ResultSet rs = ps.executeQuery();


        String id        = "";
        String login     = "";
        String password  = "";
        String role      = "";


        System.out.println(rs.next());

        while (rs.next()) {

            id        =  rs.getString("id");
            login     =  rs.getString("login");
            password  =  rs.getString("password");
            role      =  rs.getString("role");

        }

        System.out.println("id : " + id);
        System.out.println("login : " + login);
        System.out.println("password : " + password);
        System.out.println("role : " + role);

        //User user = new UserDAO().getUser("123123admin");

        //System.out.println(user);
*/

   // }
}
