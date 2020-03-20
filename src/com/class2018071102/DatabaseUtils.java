package com.class2018071102;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DatabaseUtils {

    private String tinyint = " tinyint(2),";
    private String varchar = " varchar(255),";
    private String bigint = " bigint,";
    private String int_sql = " int,";
    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    public void openDatabase(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("mysql.ini"));
            String driver = properties.getProperty(Constant.DRIVER);
            String url = properties.getProperty(Constant.URL);
            String user = properties.getProperty(Constant.USER);
            String password = properties.getProperty(Constant.PASSWORD);
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

//            StringBuffer dropDatabase = new StringBuffer();
//            dropDatabase.append("drop database if exists ").append(Constant.DATABASE).append(";");
//            statement.execute(dropDatabase.toString());
//
//            StringBuffer createDatabase = new StringBuffer();
//            createDatabase.append("create database ").append(Constant.DATABASE).append(";");
//            statement.execute(createDatabase.toString());
//
//            StringBuffer useDatabase = new StringBuffer();
//            useDatabase.append("use ").append(Constant.DATABASE).append(";");
//            statement.execute(useDatabase.toString());
//
//            StringBuffer dropTable = new StringBuffer();
//            dropTable.append("drop table if exists ").append(Constant.TABLE_QUESTIONS).append(";");
//            statement.execute(dropTable.toString());
//
//            StringBuffer createTable = new StringBuffer();
//            createTable.append("create table ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.QUESTION_ID).append(" int auto_increment primary key,").append(Constant.TYPE).append(tinyint).append(Constant.SCOPE).append(varchar).append(Constant.STEM)
//                    .append(varchar).append(Constant.OPTION_A).append(varchar).append(Constant.OPTION_B).append(varchar).append(Constant.OPTION_C).append(varchar).append(Constant.OPTION_D).append(varchar).append(Constant.QUESTION_KEY).append(varchar).append(Constant.EXPLANATION).append(varchar)
//                    .append(Constant.STATE).append(tinyint).append(Constant.ADD_TIME).append(bigint).append(Constant.UPDATE_TIME).append(" bigint);");
//            statement.execute(createTable.toString());
//
//            preparedStatement = connection.prepareStatement("insert into questions(type,scope,stem,option_a,option_b,option_c,option_d,question_key,explanation,state,add_time,update_time) values(?,?,?,?,?,?,?,?,?,?,?,?);");
//            preparedStatement.setInt(1, QuestionType.SINGLE_CHOICE.ordinal());
//            preparedStatement.setString(2,"all");
//            preparedStatement.setString(3,"夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，以下做法正确的是什么？");
//            preparedStatement.setString(4,"A、自己也打开远光灯行驶");
//            preparedStatement.setString(5,"B、降低车速，谨慎会车");
//            preparedStatement.setString(6,"C、加速通过，尽快摆脱眩目光线");
//            preparedStatement.setString(7,"D、保持行驶方向和车速不变");
//            preparedStatement.setString(8,"B");
//            preparedStatement.setString(9,"夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，降低车速，谨慎会车，以免发生车祸、危险。");
//            preparedStatement.setInt(10, QuestionState.ADDED.ordinal());
//            preparedStatement.setLong(11,System.currentTimeMillis());
//            preparedStatement.setLong(12,System.currentTimeMillis());
//            preparedStatement.executeUpdate();

            checkUserPrepared("410301198010269202","12345678");


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            release();
        }
    }

    public void checkUser(String identity_card_number,String password) throws SQLException {
        statement = connection.createStatement();
        String string = "select * from examinee where identity_card_number = ? and password = ?;";
//        StringBuffer stringBuffer = new StringBuffer();
//        stringBuffer.append("select ").append(Constant.EXAMINEE_ID,Constant.IDENTITY_CARD_NUMBER,)
        preparedStatement.setString(1,identity_card_number);
        preparedStatement.setString(2,password);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+ "||" + resultSet.getString(2) + "||" + resultSet.getString(3));
        }
    }

    public void checkUserPrepared(String identity_card_number,String password) throws SQLException {
        preparedStatement = connection.prepareStatement("select * from examinee where identity_card_number = ? and password = ?;");
        preparedStatement.setString(1,identity_card_number);
        preparedStatement.setString(2,password);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(1)+ "||" + resultSet.getString(2) + "||" + resultSet.getString(3));
        }
    }

    public void release() {
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
