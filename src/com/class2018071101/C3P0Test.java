package com.class2018071101;

import com.class2018071002.Constant;
//import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class C3P0Test {

//    public static void main(String[] args) {
//
//        try {
//            Properties properties = new Properties();
//            properties.load(new FileInputStream("mysql.ini"));
//            String driver = properties.getProperty(Constant.DRIVER);
//            String url = properties.getProperty(Constant.URL);
//            String user = properties.getProperty(Constant.USER);
//            String password = properties.getProperty(Constant.PASSWORD);
//            ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//            comboPooledDataSource.setDriverClass(driver);
//            comboPooledDataSource.setJdbcUrl(url);
//            comboPooledDataSource.setUser(user);
//            comboPooledDataSource.setPassword(password);
//            comboPooledDataSource.setMaxPoolSize(40);
//            comboPooledDataSource.setMinPoolSize(2);
//            comboPooledDataSource.setInitialPoolSize(10);
//            comboPooledDataSource.setMaxStatements(180);
//            //最大空闲时间
//            comboPooledDataSource.setMaxIdleTime(600);
//
//            Connection connection = comboPooledDataSource.getConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//    }
}
