package com.class2018071001;

import com.class2018071001.entity.ExamineeStatus;
import com.class2018071001.entity.Gender;
import com.class2018071002.entity.QuestionType;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseUtils {

    private Statement statement;
    private String tinyint = " tinyint(2),";
    private String varchar = " varchar(255),";
    private String bigint = " bigint,";
    private String int_sql = " int,";


    public void insertData(){
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("mysql.ini"));
            String driver = properties.getProperty(Constant.DRIVER);
            String url = properties.getProperty(Constant.URL);
            String user = properties.getProperty(Constant.USER);
            String password = properties.getProperty(Constant.PASSWORD);
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();

//            StringBuffer dropDatabase = new StringBuffer();
//            dropDatabase.append("drop database if exists ").append(Constant.DATABASE).append(";");
//            statement.execute(dropDatabase.toString());
//
//            StringBuffer createDatabase = new StringBuffer();
//            createDatabase.append("create database ").append(Constant.DATABASE).append(";");
//            statement.execute(createDatabase.toString());

            StringBuffer useDatabase = new StringBuffer();
            useDatabase.append("use ").append(Constant.DATABASE).append(";");
            statement.execute(useDatabase.toString());

            StringBuffer dropTable = new StringBuffer();
            dropTable.append("drop table if exists ").append(Constant.TABLE_QUESTIONS).append(";");
            statement.execute(dropTable.toString());

//            String createTable = "create table question(question_id int auto_increment primary key,type tinyint(2),scope varchar(255),stem varchar(255),option_a varchar(255),option_b varchar(255),option_c varchar(255),option_d varchar(255),question_key varchar(255),explanation varchar(255),state tinyint(2),add_time bigint,update_time bigint);";

            StringBuffer createTable = new StringBuffer();
            createTable.append("create table ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.QUESTION_ID).append(" int auto_increment primary key,").append(Constant.TYPE).append(tinyint).append(Constant.SCOPE).append(varchar).append(Constant.STEM)
                    .append(varchar).append(Constant.OPTION_A).append(varchar).append(Constant.OPTION_B).append(varchar).append(Constant.OPTION_C).append(varchar).append(Constant.OPTION_D).append(varchar).append(Constant.QUESTION_KEY).append(varchar).append(Constant.EXPLANATION).append(varchar)
                    .append(Constant.STATE).append(tinyint).append(Constant.ADD_TIME).append(bigint).append(Constant.UPDATE_TIME).append(" bigint);");
            System.out.println("createTable==" + createTable.toString());
            statement.execute(createTable.toString());

            StringBuffer insertQuestion = new StringBuffer();
            insertQuestion.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                    .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                    .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                    .append("\'all\',")
                    .append("\'夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，以下做法正确的是什么？\',")
                    .append("\'A、自己也打开远光灯行驶\',")
                    .append("\'B、降低车速，谨慎会车\',")
                    .append("\'C、加速通过，尽快摆脱眩目光线\',")
                    .append("\'D、保持行驶方向和车速不变\',")
                    .append("\'B\',")
                    .append("\'夜间驾驶机动车遇对方使用远光灯，无法看清前方路况时，降低车速，谨慎会车，以免发生车祸、危险。\',")
                    .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                    .append(System.currentTimeMillis()).append(",")
                    .append(System.currentTimeMillis())
                    .append(");");
            System.out.println(insertQuestion);
            statement.execute(insertQuestion.toString());

            insertOtherQuestions();

            StringBuffer dropTableExaminee = new StringBuffer();
            dropTableExaminee.append("drop table if exists ").append(Constant.TABLE_EXAMINEE).append(";");
            statement.execute(dropTableExaminee.toString());

            StringBuffer createTableExaminee = new StringBuffer();
            createTableExaminee.append("create table ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.EXAMINEE_ID).append(" int auto_increment primary key,").append(Constant.IDENTITY_CARD_NUMBER).append(" char(18),").append(Constant.NAME).append(varchar).append(Constant.PASSWORD).append(varchar).append(Constant.GENDER).append(tinyint).append(Constant.LICENSE_TYPE).append(int_sql)
                    .append(Constant.EXAMINEE_STATUS).append(int_sql).append(Constant.ADD_TIME).append(bigint).append(Constant.UPDATE_TIME).append(" bigint);");
            System.out.println(createTableExaminee.toString());
            statement.execute(createTableExaminee.toString());

            StringBuffer insertExaminee = new StringBuffer();
            insertExaminee.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                    .append("\'429004199707289091\',").append("\'范良策\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
            System.out.println(insertExaminee.toString());
            statement.execute(insertExaminee.toString());

            insertOtherExaminee();

            StringBuffer dropTableExamination = new StringBuffer();
            dropTableExamination.append("drop table if exists ").append(Constant.TABLE_EXAMINATION).append(";");
            statement.execute(dropTableExamination.toString());

            StringBuffer createTableExamination = new StringBuffer();
            createTableExamination.append("create table ").append(Constant.TABLE_EXAMINATION).append("(").append(Constant.EXAMINATION_ID).append(" int auto_increment primary key,").append(Constant.EXAMINEE_ID).append(int_sql).append(Constant.START_TIME).append(bigint).append(Constant.END_TIME).append(bigint).append(Constant.TOTAL_SCORE).append(" int);");
            System.out.println(createTableExamination);
            statement.execute(createTableExamination.toString());

            StringBuffer insertExamination = new StringBuffer();
            insertExamination.append("insert into ").append(Constant.TABLE_EXAMINATION).append("(").append(Constant.EXAMINEE_ID).append(",").append(Constant.START_TIME).append(") values(")
                    .append(1).append(",").append(System.currentTimeMillis()).append(");");
            System.out.println(insertExamination.toString());
            statement.execute(insertExamination.toString());

            StringBuffer dropTableExamDetail = new StringBuffer();
            dropTableExamDetail.append("drop table if exists ").append(Constant.TABLE_EXAM_DETAIL).append(";");
            statement.execute(dropTableExamDetail.toString());

            StringBuffer createExamDetail = new StringBuffer();
            createExamDetail.append("create table ").append(Constant.TABLE_EXAM_DETAIL).append("(").append(Constant.DETAIL_ID).append(" int auto_increment primary key,").append(Constant.QUESTION_ID).append(int_sql).append(Constant.ANSWER).append(varchar).append(Constant.SCORE).append(int_sql)
                    .append(Constant.ADD_TIME).append(bigint).append(Constant.UPDATE_TIME).append(" bigint);");
            System.out.println(createExamDetail.toString());
            statement.execute(createExamDetail.toString());




        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOtherExaminee() throws SQLException {
        StringBuffer insertExaminee2 = new StringBuffer();
        insertExaminee2.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'542126198505035798\',").append("\'谭星雨\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee2.toString());
        statement.execute(insertExaminee2.toString());

        StringBuffer insertExaminee3 = new StringBuffer();
        insertExaminee3.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'410301198010269202\',").append("\'周以旋\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee3.toString());
        statement.execute(insertExaminee3.toString());

        StringBuffer insertExaminee4 = new StringBuffer();
        insertExaminee4.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'430221197404093202\',").append("\'陆问兰\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee4.toString());
        statement.execute(insertExaminee4.toString());

//        StringBuffer insertExaminee5 = new StringBuffer();
//        insertExaminee5.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
//                .append("\'430221197404093202\',").append("\'陆问兰\',").append(Gender.FAMALE.ordinal()).append(",").append(LicenseType.C1.ordinal()).append(",").append(ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
//        System.out.println(insertExaminee5.toString());
//        statement.execute(insertExaminee5.toString());

        StringBuffer insertExaminee6 = new StringBuffer();
        insertExaminee6.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'500104197212181095\',").append("\'董正雅\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee6.toString());
        statement.execute(insertExaminee6.toString());

        StringBuffer insertExaminee7 = new StringBuffer();
        insertExaminee7.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'622222197406027579\',").append("\'任嘉祥\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee7.toString());
        statement.execute(insertExaminee7.toString());

        StringBuffer insertExaminee8 = new StringBuffer();
        insertExaminee8.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'422802198012273368\',").append("\'王秋荷\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee8.toString());
        statement.execute(insertExaminee8.toString());

        StringBuffer insertExaminee9 = new StringBuffer();
        insertExaminee9.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'430601198601247179\',").append("\'程奇思\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee9.toString());
        statement.execute(insertExaminee9.toString());

        StringBuffer insertExaminee10 = new StringBuffer();
        insertExaminee10.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'511321198801279837\',").append("\'林德佑\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee10.toString());
        statement.execute(insertExaminee10.toString());

        StringBuffer insertExaminee11 = new StringBuffer();
        insertExaminee11.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'450621199706204056\',").append("\'贾高芬\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee11.toString());
        statement.execute(insertExaminee11.toString());

        StringBuffer insertExaminee12 = new StringBuffer();
        insertExaminee12.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'530324199805272989\',").append("\'覃又柔\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee12.toString());
        statement.execute(insertExaminee12.toString());

        StringBuffer insertExaminee13 = new StringBuffer();
        insertExaminee13.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'420205198309100796\',").append("\'姜博文\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee13.toString());
        statement.execute(insertExaminee13.toString());

        StringBuffer insertExaminee14 = new StringBuffer();
        insertExaminee14.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'440700197608166220\',").append("\'冯天晴\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee14.toString());
        statement.execute(insertExaminee14.toString());

        StringBuffer insertExaminee15 = new StringBuffer();
        insertExaminee15.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'142625198411284431\',").append("\'罗力学\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee15.toString());
        statement.execute(insertExaminee15.toString());

        StringBuffer insertExaminee16 = new StringBuffer();
        insertExaminee16.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'542334198707056547\',").append("\'孟凌晴\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee16.toString());
        statement.execute(insertExaminee16.toString());

        StringBuffer insertExaminee17 = new StringBuffer();
        insertExaminee17.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'362430199008310674\',").append("\'于烨煜\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee17.toString());
        statement.execute(insertExaminee17.toString());

        StringBuffer insertExaminee18 = new StringBuffer();
        insertExaminee18.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'420103197712062715\',").append("\'贾良奥\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee18.toString());
        statement.execute(insertExaminee18.toString());

        StringBuffer insertExaminee19 = new StringBuffer();
        insertExaminee19.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'370304197504216815\',").append("\'蔡勇男\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee19.toString());
        statement.execute(insertExaminee19.toString());

        StringBuffer insertExaminee20 = new StringBuffer();
        insertExaminee20.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'450881199412087728\',").append("\'仇楚云\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee20.toString());
        statement.execute(insertExaminee20.toString());


        StringBuffer insertExaminee21 = new StringBuffer();
        insertExaminee21.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'411081199004235955\',").append("\'王正伟\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee21.toString());
        statement.execute(insertExaminee21.toString());

        StringBuffer insertExaminee22 = new StringBuffer();
        insertExaminee22.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'420821199206305032\',").append("\'罗江超\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee22.toString());
        statement.execute(insertExaminee22.toString());

        StringBuffer insertExaminee23 = new StringBuffer();
        insertExaminee23.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'450326198912241844\',").append("\'张玉婷\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee23.toString());
        statement.execute(insertExaminee23.toString());

        StringBuffer insertExaminee24 = new StringBuffer();
        insertExaminee24.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'432922198008015828\',").append("\'唐琳雅\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee24.toString());
        statement.execute(insertExaminee24.toString());

        StringBuffer insertExaminee25 = new StringBuffer();
        insertExaminee25.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'450881199006112350\',").append("\'潘海林\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee25.toString());
        statement.execute(insertExaminee25.toString());

        StringBuffer insertExaminee26 = new StringBuffer();
        insertExaminee26.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'612422199608063226\',").append("\'易茜茜\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee26.toString());
        statement.execute(insertExaminee26.toString());

        StringBuffer insertExaminee27 = new StringBuffer();
        insertExaminee27.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'450103197912150539\',").append("\'廖韵\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee27.toString());
        statement.execute(insertExaminee27.toString());

        StringBuffer insertExaminee28 = new StringBuffer();
        insertExaminee28.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'430111199010150308\',").append("\'江文静\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee28.toString());
        statement.execute(insertExaminee28.toString());

        StringBuffer insertExaminee29 = new StringBuffer();
        insertExaminee29.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'330205197909244850\',").append("\'柳华清\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee29.toString());
        statement.execute(insertExaminee29.toString());

        StringBuffer insertExaminee30 = new StringBuffer();
        insertExaminee30.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'522229197508122084\',").append("\'贾惠群\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee30.toString());
        statement.execute(insertExaminee30.toString());

        StringBuffer insertExaminee31 = new StringBuffer();
        insertExaminee31.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'362422197105146213\',").append("\'陈显君\',").append("\'12345678\',").append(Gender.FAMALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee31.toString());
        statement.execute(insertExaminee31.toString());

        StringBuffer insertExaminee32 = new StringBuffer();
        insertExaminee32.append("insert into ").append(Constant.TABLE_EXAMINEE).append("(").append(Constant.IDENTITY_CARD_NUMBER).append(",").append(Constant.NAME).append(",").append(Constant.PASSWORD).append(",").append(Constant.GENDER).append(",").append(Constant.LICENSE_TYPE).append(",").append(Constant.EXAMINEE_STATUS).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append("\'430281198910125618\',").append("\'文新业\',").append("\'12345678\',").append(Gender.MALE.ordinal()).append(",").append(com.class2018071002.entity.LicenseType.C1.ordinal()).append(",").append(com.class2018071002.entity.ExamineeStatus.SIGN_UP.ordinal()).append(",").append(System.currentTimeMillis()).append(",").append(System.currentTimeMillis()).append(");");
        System.out.println(insertExaminee32.toString());
        statement.execute(insertExaminee32.toString());

    }

    public void insertOtherQuestions() throws SQLException {
        StringBuffer insertQuestion2 = new StringBuffer();
        insertQuestion2.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'存在以下哪种行为的申请人在一年内不得再次申领机动车驾驶证？\',")
                .append("\'A、不能按照教学大纲认真练习驾驶技能\',")
                .append("\'B、未参加理论培训\',")
                .append("\'C、在考试过程中出现身体不适\',")
                .append("\'D、在考试过程中有舞弊行为\',")
                .append("\'D\',")
                .append("\'《机动车驾驶证申领和使用规定》第六章，法律责任，第七十八条，隐瞒有关情况或者提供虚假材料申领机动车驾驶证的，申请人在一年内不得再次申领机动车驾驶证。申请人在考试过程中有贿赂、舞弊行为的，取消考试资格，已经通过考试的其他科目成绩无效；申请人在一年内不得再次申领机动车驾驶证。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion2);
        statement.execute(insertQuestion2.toString());

        StringBuffer insertQuestion3 = new StringBuffer();
        insertQuestion3.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶机动车在道路上靠路边停车过程中如何使用灯光？\',")
                .append("\'A、提前开启右转向灯\',")
                .append("\'B、变换使用远近光灯\',")
                .append("\'C、开启危险报警闪光灯\',")
                .append("\'D、不用指示灯提示\',")
                .append("\'A\',")
                .append("\'《实施条例》第五十七条规定，机动车应当按照下列规定使用转向灯：\n" +
                        "(一)向左转弯、向左变更车道、准备超车、驶离停车地点或者掉头时，应当提前开启左转向灯；\n" +
                        "(二)向右转弯、向右变更车道、超车完毕驶回原车道、靠路边停车时，应当提前开启右转向灯。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion3);
        statement.execute(insertQuestion3.toString());

        StringBuffer insertQuestion4 = new StringBuffer();
        insertQuestion4.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'上道路行驶的机动车有哪种情形交通警察可依法扣留车辆？\',")
                .append("\'A、未携带机动车登记证书\',")
                .append("\'B、未放置检验合格标志\',")
                .append("\'C、未携带身份证\',")
                .append("\'D、未放置城市环保标志\',")
                .append("\'B\',")
                .append("\'《交通安全法》第九十五条：上道路行驶的机动车未悬挂机动车号牌，未放置检验合格标志、保险标志，或者未随车携带行驶证、驾驶证的，公安机关交通管理部门应当扣留机动车，通知当事人提供相应的牌证、标志或者补办相应手续，并可以依照本法第九十条的规定予以处罚。当事人提供相应的牌证、标志或者补办相应手续的，应当及时退还机动车。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion4);
        statement.execute(insertQuestion4.toString());


        StringBuffer insertQuestion5 = new StringBuffer();
        insertQuestion5.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶机动车行经下列哪种路段时不得超车？\',")
                .append("\'A、交叉路口\',")
                .append("\'B、高架路\',")
                .append("\'C、环城高速\',")
                .append("\'D、中心街道\',")
                .append("\'A\',")
                .append("\'道路交通安全法》第四十三条：同车道行驶的机动车，后车应当与前车保持足以采取紧急制动措施的安全距离。有下列情形之一的，不得超车：\n" +
                        "（一）前车正在左转弯、掉头、超车的；\n" +
                        "（二）与对面来车有会车可能的；\n" +
                        "（三）前车为执行紧急任务的警车、消防车、救护车、工程救险车的；\n" +
                        "（四）行经铁路道口、交叉路口、窄桥、弯道、陡坡、隧道、人行横道、市区交通流量大的路段等没有超车条件的。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion5);
        statement.execute(insertQuestion5.toString());

        StringBuffer insertQuestion6 = new StringBuffer();
        insertQuestion6.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'在涉水路段跟车时，应当怎样做？\',")
                .append("\'A、超越前车，抢先通行\',")
                .append("\'B、并行通过\',")
                .append("\'C、适当增加车距\',")
                .append("\'D、紧跟其后\',")
                .append("\'C\',")
                .append("\'适当增加车距更利于安全行车。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion6);
        statement.execute(insertQuestion6.toString());

        StringBuffer insertQuestion7 = new StringBuffer();
        insertQuestion7.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'造成交通事故后逃逸，尚不构成犯罪的一次记几分？\',")
                .append("\'A、6分\',")
                .append("\'B、12分\',")
                .append("\'C、3分\',")
                .append("\'D、2分\',")
                .append("\'B\',")
                .append("\'机动车驾驶人有下列违法行为之一，一次记12分：\n" +
                        "（一）驾驶与准驾车型不符的机动车的；\n" +
                        "（二）饮酒后驾驶机动车的；\n" +
                        "（三）驾驶营运客车（不包括公共汽车）、校车载人超过核定人数20％以上的；\n" +
                        "（四）造成交通事故后逃逸，尚不构成犯罪的；\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion7);
        statement.execute(insertQuestion7.toString());

        StringBuffer insertQuestion8 = new StringBuffer();
        insertQuestion8.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶人违反交通运输管理法规发生重大事故致人死亡且逃逸的，处多少年有期徒刑？\',")
                .append("\'A、3年以上7年以下\',")
                .append("\'B、7年以上\',")
                .append("\'C、3年以下\',")
                .append("\'D、10年以上\',")
                .append("\'A\',")
                .append("\'《中华人民共和国刑法》第一百三十三条：\n" +
                        "违反交通运输管理法规，因而发生重大事故，致人重伤、死亡或者使公私财产遭受重大损失的，处三年以下有期徒刑或者拘役；\n" +
                        "交通运输肇事后逃逸或者有其他特别恶劣情节的，处三年以上七年以下有期徒刑；\n" +
                        "因逃逸致人死亡的，处七年以上有期徒刑。\n" +
                        "看清楚了，他是“致人死亡且逃逸”，不是“因逃逸致人死亡”，所以是【3年以上7年以下】。如果是“因逃逸致人死亡”，那就是7年以上了。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion8);
        statement.execute(insertQuestion8.toString());

        StringBuffer insertQuestion9 = new StringBuffer();
        insertQuestion9.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶机动车变更车道时，以下做法正确的是什么？\',")
                .append("\'A、在车辆较少路段，可以随意变更车道\',")
                .append("\'B、开启转向灯的同时变更车道\',")
                .append("\'C、遇前方道路拥堵，可以向应急车道变更\',")
                .append("\'D、在道路同方向划有2条以上机动车道的，不得影响相关车道内行驶的机动车的正常行驶\',")
                .append("\'D\',")
                .append("\'做题绝技，ABCD那个答案比较长就选哪个，对了\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion9);
        statement.execute(insertQuestion9.toString());

        StringBuffer insertQuestion10 = new StringBuffer();
        insertQuestion10.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶机动车在道路上违反道路交通安全法的行为，属于什么行为？\',")
                .append("\'A、违章行为\',")
                .append("\'B、违法行为\',")
                .append("\'C、过失行为\',")
                .append("\'D、违规行为\',")
                .append("\'B\',")
                .append("\'“违反道路交通安全法”，违反法律法规即为违法行为。官方已无违章/违规的说法。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion10);
        statement.execute(insertQuestion10.toString());

        StringBuffer insertQuestion11 = new StringBuffer();
        insertQuestion11.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶机动车应当随身携带哪种证件？\',")
                .append("\'A、工作证\',")
                .append("\'B、驾驶证\',")
                .append("\'C、身份证\',")
                .append("\'D、职业资格证\',")
                .append("\'B\',")
                .append("\'《道路交通安全法》第十九条：驾驶人应当按照驾驶证载明的准驾车型驾驶机动车；驾驶机动车时，应当随身携带机动车驾驶证。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion11);
        statement.execute(insertQuestion11.toString());

        StringBuffer insertQuestion12 = new StringBuffer();
        insertQuestion12.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'机动车驾驶人初次申领驾驶证后的实习期是多长时间？\',")
                .append("\'A、6个月\',")
                .append("\'B、12个月\',")
                .append("\'C、16个月\',")
                .append("\'D、18个月\',")
                .append("\'B\',")
                .append("\'《公安部令第123号》第六十四条规定：机动车驾驶人初次申请机动车驾驶证和增加准驾车型后的12个月为实习期。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion12);
        statement.execute(insertQuestion12.toString());

        StringBuffer insertQuestion13 = new StringBuffer();
        insertQuestion13.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂哪种标志？\',")
                .append("\'A、注意新手标志\',")
                .append("\'B、注意避让标志\',")
                .append("\'C、统一式样的实习标志\',")
                .append("\'D、注意车距标志\',")
                .append("\'C\',")
                .append("\'《公安部令第123号》第六十四条规定：在实习期内驾驶机动车的，应当在车身后部粘贴或者悬挂统一式样的实习标志。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion13);
        statement.execute(insertQuestion13.toString());

        StringBuffer insertQuestion14 = new StringBuffer();
        insertQuestion14.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'以欺骗、贿赂等不正当手段取得驾驶证被依法撤销驾驶许可的，多长时间不得重新申请驾驶许可？\',")
                .append("\'A、3年内\',")
                .append("\'B、终身\',")
                .append("\'C、1年内\',")
                .append("\'D、5年内\',")
                .append("\'A\',")
                .append("\'《公安部令第123号》第七十八条规定：申请人以欺骗、贿赂等不正当手段取得机动车驾驶证的，公安机关交通管理部门收缴机动车驾驶证，撤销机动车驾驶许可；申请人在三年内不得再次申领机动车驾驶证。吊销机动车证的为二年，撤销机动车证的为三年，以醉酒吊销五年，因逃跑而吊销是终身，叫“吊二撤三醉五逃终身”\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion14);
        statement.execute(insertQuestion14.toString());

        StringBuffer insertQuestion15 = new StringBuffer();
        insertQuestion15.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.SINGLE_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶机动车遇到前方车辆停车排队等候或缓慢行驶时怎么办？\',")
                .append("\'A、可借道超车\',")
                .append("\'B、占用对面车道\',")
                .append("\'C、穿插等候的车辆\',")
                .append("\'D、依次行驶\',")
                .append("\'D\',")
                .append("\'《道路交通安全法》第四十五条：机动车遇有前方车辆停车排队等候或者缓慢行驶时，不得借道超车或者占用对面车道，不得穿插等候的车辆。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion15);
        statement.execute(insertQuestion15.toString());

        StringBuffer insertQuestion16 = new StringBuffer();
        insertQuestion16.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'林某驾车以110公里/小时的速度在城市道路行驶，与一辆机动车追尾后弃车逃离被群众拦下。经鉴定，事发时林某血液中的酒精浓度为135.8毫克/百毫升。林某的主要违法行为是什么？\',")
                .append("\'A、醉酒驾驶\',")
                .append("\'B、超速驾驶\',")
                .append("\'C、疲劳驾驶\',")
                .append("\'D、肇事逃逸\',")
                .append("\'ABD\',")
                .append("\'违法行为一：以110公里/小时的速度在城市道路行驶违法行为；二：与一辆机动车追尾后弃车逃离违法行为；三：林某血液中的酒精浓度为135.8毫克/百毫升。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion16);
        statement.execute(insertQuestion16.toString());

        StringBuffer insertQuestion17 = new StringBuffer();
        insertQuestion17.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'行车中驾驶人接打手机或发短信有什么危害？\',")
                .append("\'A、影响乘车人休息\',")
                .append("\'B、分散驾驶注意力\',")
                .append("\'C、影响正常驾驶操作\',")
                .append("\'D、遇紧急情况反应不及\',")
                .append("\'BCD\',")
                .append("\'接打手机或者发短信时不能双手握住方向盘，会影响正常驾驶操作，此时也要分心与对方交流，会分散注意力，此时发生紧急状况，肯定会反应不及。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion17);
        statement.execute(insertQuestion17.toString());

        StringBuffer insertQuestion18 = new StringBuffer();
        insertQuestion18.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'下列做法哪些可以有效避免驾驶疲劳？\',")
                .append("\'A、连续驾驶不超过4小时\',")
                .append("\'B、用餐不宜过饱\',")
                .append("\'C、保持良好的睡眠\',")
                .append("\'D、餐后适当休息后驾车\',")
                .append("\'ABCD\',")
                .append("\'无\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion18);
        statement.execute(insertQuestion18.toString());

        StringBuffer insertQuestion19 = new StringBuffer();
        insertQuestion19.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'驾驶汽车超速行驶有哪些危害？\',")
                .append("\'A、反应距离延长\',")
                .append("\'B、视野变窄\',")
                .append("\'C、加重事故后果\',")
                .append("\'D、制动距离延长\',")
                .append("\'ABCD\',")
                .append("\'驾驶汽车超速行驶使得反应距离延长；同时过快的车速使得两边的事物会比较模糊，视野变窄；太快的车速，由于惯性作用，就会加重事故后果以及制动距离延长等危害。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion19);
        statement.execute(insertQuestion19.toString());

        StringBuffer insertQuestion20 = new StringBuffer();
        insertQuestion20.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'叶某驾驶中型厢式货车，行至陂头镇上汶线3公里加600米弯道路段时，以40公里/小时的速度与王某驾驶的乘载19人正三轮载货摩托车发生正面相撞，造成10人死亡、9人受伤。双方驾驶人的主要违法行为是什么？\',")
                .append("\'A、叶某驾驶与准驾车型不符的机动车\',")
                .append("\'B、王某驾驶摩托车非法载客\',")
                .append("\'C、叶某超速行驶\',")
                .append("\'D、王某不按信号灯指示行驶\',")
                .append("\'BC\',")
                .append("\'弯道限速30公里/小时，以40公里/小时的速度行驶是超速。载货摩托车载客是非法载客。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion20);
        statement.execute(insertQuestion20.toString());

        StringBuffer insertQuestion21 = new StringBuffer();
        insertQuestion21.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'某日19时，杨某驾驶大客车，乘载57人（核载55人），连续行驶至次日凌晨1时,在金城江区境内050国道3008公里加110米处，因机动车左前胎爆裂，造成12人死亡、22人受伤的特大交通事故。杨某的主要违法行为是什么？\',")
                .append("\'A、疲劳驾驶\',")
                .append("\'B、客车超员\',")
                .append("\'C、超速行驶\',")
                .append("\'D、操作不当\',")
                .append("\'AB\',")
                .append("\'违法行为：1、题目提到连续行驶到次日凌晨1时，属疲劳驾驶。2、题目提到只能做55以上，却坐了57人，属客车超员。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion21);
        statement.execute(insertQuestion21.toString());

        StringBuffer insertQuestion22 = new StringBuffer();
        insertQuestion22.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(com.class2018071002.entity.QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'钱某驾驶大型卧铺客车，乘载45人（核载40人），保持40公里/小时以上的车速行至八宿县境内连续下坡急转弯路段处，翻下100米深的山崖，造成17人死亡、20人受伤。钱某的主要违法行为是什么？\',")
                .append("\'A、驾驶时接听手持电话\',")
                .append("\'B、超速行驶\',")
                .append("\'C、客车超员\',")
                .append("\'D、疲劳驾驶\',")
                .append("\'BC\',")
                .append("\'违法行为：1、弯道限速30公里/每小时，故超速行驶。2、乘载45人(核载40人)，故客车超员。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion22);
        statement.execute(insertQuestion22.toString());

        StringBuffer insertQuestion23 = new StringBuffer();
        insertQuestion23.append("insert into ").append(Constant.TABLE_QUESTIONS).append("(").append(Constant.TYPE).append(",").append(Constant.SCOPE).append(",").append(Constant.STEM).append(",").append(Constant.OPTION_A).append(",").append(Constant.OPTION_B).append(",").append(Constant.OPTION_C).append(",")
                .append(Constant.OPTION_D).append(",").append(Constant.QUESTION_KEY).append(",").append(Constant.EXPLANATION).append(",").append(Constant.STATE).append(",").append(Constant.ADD_TIME).append(",").append(Constant.UPDATE_TIME).append(") values(")
                .append(QuestionType.MULTI_CHOICE.ordinal()).append(",")
                .append("\'all\',")
                .append("\'某日3时40分，孙某驾驶大客车（乘载54人、核载55人）行至随岳高速公路229公里加300米处，在停车下客过程中，被后方驶来李某驾驶的重型半挂机动车追尾，造成26人死亡，29人受伤。事后查明，李某从昨日18时许出发，途中一直未休息。双方驾驶人的主要违法行为是什么？\',")
                .append("\'A、孙某违法停车\',")
                .append("\'B、孙某客车超员\',")
                .append("\'C、李某超速\',")
                .append("\'D、李某疲劳驾驶\',")
                .append("\'AD\',")
                .append("\'违法行为：1、高速公路上不允许停车下客。2、李某从昨日18时许出发，途中一直未休息。故属于疲劳驾驶。\',")
                .append(com.class2018071002.entity.QuestionState.ADDED.ordinal()).append(",")
                .append(System.currentTimeMillis()).append(",")
                .append(System.currentTimeMillis())
                .append(");");
        System.out.println(insertQuestion23);
        statement.execute(insertQuestion23.toString());
    }
}
