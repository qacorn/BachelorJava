package com.class2018070903;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DriverTestDatabase {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("mysql.ini"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            String dropDatabase = "drop database if exists driver;";
            statement.execute(dropDatabase);
            String createDatabase = "create database driver;";
            statement.execute(createDatabase);
            String useDatabase = "use driver";
            statement.execute(useDatabase);
//            String dropTable = "drop table if exists questions;";
//            statement.execute(dropTable);
            String createTable = "create table question(question_id int auto_increment primary key,type tinyint(2),scope varchar(255),stem varchar(255),option_a varchar(255),option_b varchar(255),option_c varchar(255),option_d varchar(255),question_key varchar(255),explanation varchar(255),state tinyint(2),add_time bigint,update_time bigint);";
            System.out.println("createTable==" + createTable);
            boolean create = statement.execute(createTable);
//            System.out.println("create==" + create);
            StringBuffer insertQuestion2 = new StringBuffer();
            insertQuestion2.append("insert into question(type,scope,stem,option_a,option_b,option_c,option_d,question_key,explanation,state,add_time,update_time) values(")
//            insertQuestion2.append("insert into questions values(")
                    .append(0).append(",")
                    .append("\'all\',")
                    .append("\'夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，以下做法正确的是什么？\',")
                    .append("\'A、自己也打开远光灯行驶\',")
                    .append("\'B、降低车速，谨慎会车\',")
                    .append("\'C、加速通过，尽快摆脱眩目光线\',")
                    .append("\'D、保持行驶方向和车速不变\',")
                    .append("\'B\',")
                    .append("\'夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，降低车速，谨慎会车，以免发生车祸、危险。\',")
                    .append(0).append(",")
                    .append(System.currentTimeMillis()).append(",")
                    .append(System.currentTimeMillis())
                    .append(");");
            System.out.println(insertQuestion2);
            boolean insert = statement.execute(insertQuestion2.toString());
            System.out.println("insert==" + insert);


//            String insertQuestion = "insert into questions values(0,'all','夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，以下做法正确的是什么？','A、自己也打开远光灯行驶','B、降低车速，谨慎会车','C、加速通过，尽快摆脱眩目光线','D、保持行驶方向和车速不变','B','夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，降低车速，谨慎会车，以免发生车祸、危险。');";


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
