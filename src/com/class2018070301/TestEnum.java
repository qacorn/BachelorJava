package com.class2018070301;

import java.lang.reflect.Modifier;

public enum TestEnum {

    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;

    public static void test(String[] args) {
        values();
        valueOf("MONDAY");

    }

//    public static TestEnum valueOf(String s){
//        return (TestEnum)Enum.valueOf(TestEnum.class,s);
//    }



}
