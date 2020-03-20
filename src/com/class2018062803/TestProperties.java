package com.class2018062803;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {

    public static void main(String[] args) {
//        new com.class2018062806.TestProperties();
        Properties properties = new Properties();

        try {
            InputStream inputStream = TestProperties.class.getResourceAsStream("src/test.properties");
            if (inputStream!=null) {
                properties.load(inputStream);
            }
            System.out.println(properties.get("user"));
            System.out.println(properties.get("address"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
