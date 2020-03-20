package com.class2018070902;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ExecuteDDL {

    private String driver;
    private String url;
    private String user;
    private String password;

    public void initParam(String paramFile){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(paramFile));
            driver = properties.getProperty("driver");
            System.out.println(driver + "|||||");
            url = properties.getProperty("url");
            System.out.println(url+"|||||||");
            user = properties.getProperty("user");
            System.out.println(user+"|||||||");
            password = properties.getProperty("password");
            System.out.println(password+"|||||||");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void createTable(String sql){
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        ExecuteDDL executeDDL = new ExecuteDDL();
        executeDDL.initParam("mysql.ini");
//        executeDDL.createTable("create table jdbc_test01" + "(jdbc_id int auto_increment primary key," + "jdbc_name varchar(255)," + "jdbc_desc text);");
    }
}
