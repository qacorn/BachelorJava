package com.class2018071103.test;

import java.sql.*;

public class Test2 {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        checkUser(1111L, "aaa' or '1' = '1");
    }

    public static void checkUser(Long userId, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //构建连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/haimian?" +
                    "user=wangyajun&password=haimian123&serverTimezone=Asia/Shanghai&useSSL=false");
            //打开用于承在sql语句的statement；
            String sql = "select * from hm_user where user_Id = ? and user_password = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Long userIdToShow = resultSet.getLong(2);
                String userName = resultSet.getString(3);
                String schoolName = resultSet.getString(4);
                Byte sex = resultSet.getByte(5);
                System.out.printf("userId: %d, userName: %s, schoolName: %s, sex: %d\n", userIdToShow, userName, schoolName, sex);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connection);
        }
    }

    private static void release(ResultSet resultSet, Statement statement, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
