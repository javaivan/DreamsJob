package com.ivanmix;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException, SQLException {





/*
        try {


            Runtime rt = Runtime.getRuntime();
            //Process pr = rt.exec("cmd /c dir");
            String command = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump --dbname=postgresql://dreams_job:dreams_job@127.0.0.1:5432/dreams_job > c:\\text.txt0 ";
            Process pr = rt.exec(command);
            Process runtime = Runtime.getRuntime().exec("cmd /c start " + command);

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
        }
*/
        //String command = "cmd.exe /c set path=C:/Program Files/PostgreSQL/9.5/bin/pg_dump --dbname=postgresql://dreams_job:dreams_job@127.0.0.1:5432/dreams_job";
        /*String command = "cmd.exe set asdf";

        Process p = Runtime.getRuntime().exec(command);
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line=null;

        while((line=input.readLine()) != null) {
            System.out.println(line);
        }
*/
        /*
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd \"C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump\" && dir");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }*/

        /*String command = "cmd /c start cmd.exe";
        Process child = Runtime.getRuntime().exec(command);
*/
// Get output stream to write from it
        /*String[] command =
                {
                        "cmd",
                };
        Process p = Runtime.getRuntime().exec(command);

        PrintWriter stdin = new PrintWriter(p.getOutputStream());
        stdin.println("C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump --dbname=postgresql://dreams_job:dreams_job@127.0.0.1:5432/dreams_job > c:\\text.txt044 ");
        // write any other commands you want here
        stdin.close();
        int returnCode = p.waitFor();
        System.out.println("Return code = " + returnCode);
*/
        /*
        try {
            Process p = Runtime
                    .getRuntime()
                    //.exec("cmd /c start cmd.exe /K \"dir && ping localhost && echo end\"");
                    //.exec("cmd /c start cmd.exe /K \"cd C:\\Program Files\\PostgreSQL\\9.5\\bin\\ && echo  pg_dump --dbname=postgresql://dreams_job:dreams_job@127.0.0.1:5432/dreams_job > c:\\text.txt044 && echo end\"");
                     .exec("cmd /c start cmd.exe /K \"echo &&  C: && /Program Files");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        /*http://stackoverflow.com/questions/24405681/with-java-run-multiple-commands-in-the-same-cmd-exe-window/24406721#24406721*/



    /*

            //return Lists.newArrayList(projectRepository.findAll(new PageRequest(1,20,Sort.Direction.DESC)));
        //new Sort(Sort.Direction.DESC, "id")
    * new PageRequest(
    *
    * Sort.Direction.DESC
/*
    @Query("select u from User u JOIN ReplyStatus r where r.role = :role")
    List<User> findByRole(@Param("role") String role);
*/
/*


        @Query("select b FROM BidReceivedEventEntity b JOIN PushEventEntity p " +
            "WHERE (p.eventId=b.eventId and p.itemId =:itemId and p.eventPrice=:eventPrice)")
        public Iterable searchBidsByItemIdAndPrice(@Param("itemId") String itemId, @Param("eventPrice") double eventPrice);



    @Query("select u from de.ppi.samples.fuwesta.model.User u inner join u.postings Post "
            + "where (u.firstName = :firstname1 or "
            + "u.irstName = :firstname2) and Post.title = :title\")\n" +
            "    List<User> nonsensFinder(@Param(\"firstname1\") String firstname1,f
                             @Param("firstname2") String firstname2,
                             @Param("title") String title);*/





    }
}
