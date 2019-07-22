package com.stackroute.jdbc;

import java.sql.*;

public class ResultSetMetadataDemo {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public void getMetaDataOfResultSet() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sraddha", "root", "Root@123");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("Select * from employee");) {
            ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
            System.out.println("------------------------------------------");
            System.out.println("META DATA INFO");
            System.out.println("------------------------------------------");
            System.out.println("Number of columns in employee table are:" + resultSetMetaData.getColumnCount());

            System.out.println("Column name :" + resultSetMetaData.getColumnName(1));
            System.out.println("Column data type:" + resultSetMetaData.getColumnTypeName(2));
            System.out.println(resultSetMetaData.getColumnType(2));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
