package com.ivanmix;

import com.ivanmix.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.*;

import static org.junit.Assert.assertNotNull;


public class AllTests {

    @BeforeClass
    public static void init() throws IOException, InterruptedException {
        System.out.println("Before all");
/*
        try
        {
            Connection con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/dreams_job","dreams_job","dreams_job");
            Connection con1 = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/dreams_job_test","dreams_job","dreams_job");

            String sql = "INSERT INTO users("+ "name,"+ "active,"+ "login,"+ "password)"+ "VALUES(?,?,?,?)";

            Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

            PreparedStatement pstmt = con1.prepareStatement(sql);

            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while ( rs.next() )
            {
                String nm = rs.getString(2);
                Boolean ac = rs.getBoolean(3);
                String log = rs.getString(4);
                String pass = rs.getString(5);
                pstmt.setString(1, nm);
                pstmt.setBoolean(2, ac);
                pstmt.setString(3, log);
                pstmt.setString(4, pass);
                pstmt.executeUpdate();
            }
            con.close();
            con1.close();
        }
        catch (SQLException e)
        {
            System.out.println("could not get JDBC connection: " +e);
        }
*/

/*
        try
        {


            Connection con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/dreams_job","dreams_job","dreams_job");
            try
            {
                Connection con1 = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/dreams_job_test","dreams_job","dreams_job");

                Statement st = con.createStatement();
                Statement st1 = con1.createStatement();
                ResultSet rs = st.executeQuery("SELECT column_name, column_default, data_type FROM INFORMATION_SCHEMA.COLUMNS  WHERE table_name = user");

                System.out.println(rs);


                while ( rs.next() )
                {
                    String nm = rs.getString(2);
                    Boolean ac = rs.getBoolean(3);
                    String log = rs.getString(4);
                    String pass = rs.getString(5);
                    pstmt.setString(1, nm);
                    pstmt.setBoolean(2, ac);
                    pstmt.setString(3, log);
                    pstmt.setString(4, pass);
                    pstmt.executeUpdate();
                }

                rs.close();
                st.close();
                st1.close();
            }
            catch(SQLException e)
            {
                System.out.println( "could not get JDBC connection for new_db: " + e );
            }
        }
        catch(SQLException e)
        {
            System.out.println( "could not get JDBC connection for  old_db: " + e );
        }*/













/*

        String database = "dreams_job";
// your cPanel username and password here - the user has MySQL LOCK TABLE right
        String username = "dreams_job";
        String password = "dreams_job";
// String dumpdir = "./dumps";

        String urlmysql = "jdbc:mysql://localhost/";
        String urlpsql = "jdbc:postgresql://localhost/template1";




        //String executeCmd  = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump -U " + username + " -w "+ username +" -c -f " + database + ".sql " + database;

        String executeCmd  = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump --dbname=postgresql://dreams_job:dreams_job@127.0.0.1:5432/dreams_job > c:\\2text.txt ";

        System.out.println(executeCmd);
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            System.out.println(runtimeProcess);
            int processComplete = runtimeProcess.waitFor();
            System.out.println(processComplete);
            if (processComplete == 0) {
                System.out.println("Backup created successfully");
            } else {
                System.out.println("Could not create the backup");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }



*/
/*
        String pgDump = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump";
        String dumpFile = "C:\\test.sql";
        String sql = pgDump +" -h localhost -U dreams_job -P dreams_job dreams_job > "+dumpFile;
        Process p = Runtime.getRuntime().exec(sql);
        int time = p.waitFor();
        System.out.println("time is "+time);
        if(time == 0){
            System.out.println("backup is created");
        }
        else{
            System.out.println("fail to create backup");
        }*/

/*
        String command = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump --dbname=postgresql://dreams_job:dreams_job@127.0.0.1:5432/dreams_job > c:\\text.txt0 ";



        try {
            // Execute command
           // String command = "cmd /c start cmd.exe";
            Process child = Runtime.getRuntime().exec(command);

            // Get output stream to write from it
            OutputStream out = child.getOutputStream();

            out.write("cd C:/ /r/n".getBytes());
            out.flush();
            out.write("dir /r/n".getBytes());
            out.close();
        } catch (IOException e) {
        }


*/
/*
        try {
            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            Process pr = rt.exec("C:\\Program Files\\PostgreSQL\\9.5\\\\bin\\pg_dump ");

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line=null;

            while((line=input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);

        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }*/







    }

    @Test
    public void initTest() {

        System.out.println("initTest OK");
    }
}
