package com.class2018071103.dao;


import com.class2018071103.bean.HmUser;
import com.class2018071103.bean.info.HmUserMetaInfo;
import com.class2018071103.utils.ListUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HmUserDaoImpl implements HmUserDao {

    @Override
    public Boolean addUser(Long userId, String userName, String userSchool, Byte userSex) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //构建连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/haimian?" +
                    "user=wangyajun&password=haimian123&serverTimezone=Asia/Shanghai&useSSL=false");
            //打开用于承在sql语句的statement；
            String sql = "INSERT INTO hm_user(user_id, user_name, user_school, user_sex) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userSchool);
            preparedStatement.setByte(4, userSex);

            return 1 == preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connection);
        }
        return false;
    }

    public List<HmUserMetaInfo> getUserListFromIdList(List<Long> userIdList) {
        if (ListUtils.isEmpty(userIdList)) {
            return Collections.emptyList();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //构建连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/haimian?" +
                    "user=wangyajun&password=haimian123&serverTimezone=Asia/Shanghai&useSSL=false");
            //打开用于承在sql语句的statement；
            if (userIdList.size() > 1000) {
                for (int i = 0; i < userIdList.size() / 1000 + 1; i ++) {

                }
            }
            String tempFill = "";
            for (int i = 0; i < userIdList.size(); i ++) {
                tempFill += "?,";
            }
            String substring = tempFill.substring(0, tempFill.length() - 1);
            String sql = "SELECT * FROM hm_user where user_id in (" + substring + ");";
            preparedStatement = connection.prepareStatement(sql);
            int index = 1;
            for (int i = 0; i < userIdList.size(); i ++) {
                preparedStatement.setLong(index ++, userIdList.get(i));
            }

            resultSet = preparedStatement.executeQuery();

            List<HmUser> userList = new ArrayList<>(userIdList.size());
            while (resultSet.next()) {
                HmUser hmUser = new HmUser();
                hmUser.setUserIndex(resultSet.getInt(1));
                hmUser.setUserId(resultSet.getLong(2));
                hmUser.setUserName(resultSet.getString(3));
                hmUser.setUserSchool(resultSet.getString(4));
                hmUser.setUserSex(resultSet.getByte(5));
                hmUser.setPassword(resultSet.getString(6));
                hmUser.setHeadImg(resultSet.getString(7));
                userList.add(hmUser);
            }
            return HmUserMetaInfo.buildList(userList);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            release(resultSet, preparedStatement, connection);
        }
        return Collections.emptyList();
    }

    private void release(ResultSet resultSet, Statement statement, Connection connection) {
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
