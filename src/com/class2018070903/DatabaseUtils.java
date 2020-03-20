package com.class2018070903;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtils {

    public void initParam(String paramFile){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(paramFile));
            String driver = properties.getProperty("driver");
            System.out.println(driver);
            String url = properties.getProperty("url");
            System.out.println(url);
            String user = properties.getProperty("user");
            System.out.println(user);
            String password = properties.getProperty("password");
            System.out.println(password);

            try {
                Class.forName(driver);
                Connection connection = DriverManager.getConnection(url,user,password);
//                Statement statement = connection.createStatement();
//                statement.executeUpdate(sql);
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
