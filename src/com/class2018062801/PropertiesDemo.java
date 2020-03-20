package com.class2018062801;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("name","root");
        properties.put("pass","root");
        properties.put("url","jdbc:mysql://localhost:3306/db");

        String name = properties.getProperty("name");
        System.out.println(name);

        System.out.println("--------华丽丽的分割线-----------------");
        System.out.println("--------华丽丽的分割线-----------------");
        Set<Object> propertySet = properties.keySet();

        Iterator<Object> iterator = propertySet.iterator();

        while (iterator.hasNext()){
//            iterator.next();
            System.out.println(iterator.next());
        }

        System.out.println("--------华丽丽的分割线-----------------");
        System.out.println("--------华丽丽的分割线-----------------");

        Set<String> stringsSet = properties.stringPropertyNames();
        Iterator<String> iterator002 = stringsSet.iterator();

        while (iterator002.hasNext()){
//            System.out.println(iterator002.next());
            System.out.println(properties.get(iterator002.next()));
        }




    }

}
