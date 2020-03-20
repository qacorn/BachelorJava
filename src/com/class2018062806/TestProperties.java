package com.class2018062806;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) {


//        InputStream inputStream = TestProperties.class.getResourceAsStream("C:\\Users\\Michael\\IdeaProjects\\blockchain\\src\\main\\java\\com\\class2018062806\\test.properties");
        InputStream inputStream = TestProperties.class.getClassLoader().getResourceAsStream("/com/class2018062806/test.properties");
//        InputStream inputStream = TestProperties.class.getClassLoader().getResourceAsStream("C:\\Users\\Michael\\IdeaProjects\\blockchain\\src\\main\\java\\com\\class2018062806\\test.properties");

        Properties properties = new Properties();
        try {
//            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Michael\\IdeaProjects\\blockchain\\src\\main\\java\\com\\class2018062806\\test.properties");
//            FileInputStream fileInputStream = new FileInputStream("src/test.properties");
            //需要把test.properties   放在blockchain 文件夹下
            FileInputStream fileInputStream = new FileInputStream("test.properties");
            properties.load(fileInputStream);
            System.out.println(properties.get("user"));
            System.out.println(properties.get("address"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
