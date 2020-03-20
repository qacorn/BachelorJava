package com.class2018071101;

import com.class2018071002.Constant;
//import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {

//    public static void main(String[] args) {
//        try {
//            Properties properties = new Properties();
//            properties.load(new FileInputStream("mysql.ini"));
//            String driver = properties.getProperty(Constant.DRIVER);
//            String url = properties.getProperty(Constant.URL);
//            String user = properties.getProperty(Constant.USER);
//            String password = properties.getProperty(Constant.PASSWORD);
//            BasicDataSource basicDataSource = new BasicDataSource();
//            basicDataSource.setDriverClassName(driver);
//            basicDataSource.setUrl(url);
//            basicDataSource.setUsername(user);
//            basicDataSource.setPassword(password);
//            basicDataSource.setInitialSize(5);
//            basicDataSource.setMinIdle(2);
//
//            Connection connection = basicDataSource.getConnection();
//            connection.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
