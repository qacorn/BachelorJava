package com.class2018071103.test;

import java.sql.*;

public class Test {

    static {
        try {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        checkUser(1111L, "aaa'; delete table hm_user where '1' = '1");
        checkUser(1111L, "aaa' or '1' = '1");
//        checkUser(1111L, "jdfksja");


    }

    public static void checkUser(Long userId, String password) {
        try {
            //构建连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/haimian?" +
                    "user=wangyajun&password=haimian123&serverTimezone=Asia/Shanghai&useSSL=false");
            //打开用于承在sql语句的statement；
            Statement statement = connection.createStatement();
            String sql = "select * from hm_user WHERE user_id = " + userId + " and user_password='" +password + "';";
            //执行sql
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Long userIdToShow = resultSet.getLong(2);
                String userName = resultSet.getString(3);
                String schoolName = resultSet.getString(4);
                Byte sex = resultSet.getByte(5);
                System.out.printf("userId: %d, userName: %s, schoolName: %s, sex: %d\n", userIdToShow, userName, schoolName, sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
