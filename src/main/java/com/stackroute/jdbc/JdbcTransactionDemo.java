package com.stackroute.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class JdbcTransactionDemo {

    public void TransactionProcessDemo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sraddha", "root", "Root@123");

            PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?)");

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            con.setAutoCommit(false);
            while(true){

                System.out.println("enter id");
                String s1=br.readLine();
                int id=Integer.parseInt(s1);

                System.out.println("enter name");
                String name=br.readLine();

                System.out.println("enter age");
                String s3=br.readLine();
                int age=Integer.parseInt(s3);

                System.out.println("enter gender");
                String gender=br.readLine();

                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setInt(3,age);
                ps.setString(4,gender);
                ps.executeUpdate();

                System.out.println("commit/rollback");
                String answer=br.readLine();
                if(answer.equals("commit")){
                    con.commit();
                }
                if(answer.equals("rollback")){
                    con.rollback();
                }


                System.out.println("Want to add more records y/n");
                String ans=br.readLine();
                if(ans.equals("n")){
                    break;
                }

            }
            con.commit();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
