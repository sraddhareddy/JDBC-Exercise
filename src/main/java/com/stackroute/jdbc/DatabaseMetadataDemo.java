package com.stackroute.jdbc;

import java.sql.*;

public class DatabaseMetadataDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public void getMetaDataOfDatabase() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sraddha", "root", "Root@123");){
             DatabaseMetaData databaseMetadataDemo=  connection.getMetaData();
              System.out.println("------------------------------------------");
            System.out.println("META DATA INFO");
            System.out.println("------------------------------------------");
            System.out.println("Driver name:" + databaseMetadataDemo.getDriverName());
            System.out.println("Product name :" + databaseMetadataDemo.getDatabaseProductName());
            System.out.println("Product version:" + databaseMetadataDemo.getDatabaseProductVersion());
            System.out.println("columns in index:" + databaseMetadataDemo.getMaxColumnsInIndex());
            System.out.println("username:" + databaseMetadataDemo.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
