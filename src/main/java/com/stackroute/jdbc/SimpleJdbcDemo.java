package com.stackroute.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SimpleJdbcDemo {

    private Connection connection;
    private  Statement statement;
    private ResultSet resultSet;
    public void getEmployeeDetails() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sraddha", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");)
        {
            /*Load driver and register with DriverManager*/

            /*Use DriverManager to get Connection*/
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "Root@123");

//             statement = connection.createStatement();
//
//             resultSet = statement.executeQuery("Select * from employee");

             while (resultSet.next()) {
                System.out.println("Id: " + resultSet.getInt(1) + " Name: " + resultSet.getString(2));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
//        finally {
//            try {
//                connection.close();
//                statement.close();
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

        }


    /*Print ResultSet in reverse order*/
    public void getEmployeeDetailsInReverse() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sraddha", "root", "Root@123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from employee");
            resultSet.afterLast();
            System.out.println("-------------------------------");
            while (resultSet.previous()){
                System.out.println("Id:" + resultSet.getInt(1)+" "+ "Name:" + " " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /*Move ResultSet to second row and print in reverse order*/
    public void getEmployeeDetailsFromSecondRowInReverse() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sraddha", "root", "Root@123");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from employee");
            resultSet.absolute(3);
            System.out.println("-------------------------------");
            while (resultSet.previous()){
                System.out.println("Id:" + resultSet.getInt(1)+" "+ "Name:" + " " + resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Use PreparedStatement to display by name and gender

    public void getEmployeeDetailsByNameAndGender(String name,String gender) {


        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sraddha", "root", "Root@123");
            PreparedStatement statement = connection.prepareStatement("Select * from employee where name=? and gender=?");

            statement.setString(1,name);
            statement.setString(2,gender);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("-------------------------------");
            while (resultSet.next()){
                System.out.println("ID:" + " "+resultSet.getInt(1)+" "+ "Name:" + resultSet.getString(2)+" "+"Age:" + " "+resultSet.getInt(3)+" "+ "Gender:" + " " + resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}