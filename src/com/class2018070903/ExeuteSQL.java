package com.class2018070903;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ExeuteSQL {


    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("mysql.ini"));
            String driver = properties.getProperty("driver");
//            System.out.println(driver);
            String url = properties.getProperty("url");
//            System.out.println(url);
            String user = properties.getProperty("user");
//            System.out.println(user);
            String password = properties.getProperty("password");
//            System.out.println(password);

            try {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(url,user,password);
                Statement statement = connection.createStatement();
//                StringBuffer dropTable = new StringBuffer();
//                dropTable.append("")
                String createDatabase = "create database sponge;";
//                statement.execute(createDatabase);
//show databases  using sql
                String showDatabase = "show databases;";
                ResultSet resultSet = statement.executeQuery(showDatabase);
//                resultSet.getString(0);
//                System.out.println(resultSet.getString(0));
                while (resultSet.next()){
                    System.out.println(resultSet.getString(1));
                }
//show databases  using MetaData
                //Use DatabaseMetaData#getCatalogs(). It returns a ResultSet with database names in 1st column.
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet catalogs = metaData.getCatalogs();
                while (catalogs.next()){
                    System.out.println(catalogs.getString("TABLE_CAT"));
                    StringBuffer useDatabase = new StringBuffer();
                    useDatabase.append("use").append(" ").append(catalogs.getString("TABLE_CAT")).append(";");
                    statement.execute(useDatabase.toString());
                    ResultSet show_tables = statement.executeQuery("show tables");
                    while (show_tables.next()){
                        System.out.println("------------------------" + show_tables.getString(1));
                    }

                }

//                String dropDatabase = "drop database test;";
//                statement.execute(dropDatabase);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
