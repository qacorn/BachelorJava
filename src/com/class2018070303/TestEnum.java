package com.class2018070303;

public enum TestEnum {
    MONDAY,FRIDAY;



    public static void test() {
        values();
        valueOf("MONDAY");
    }

//    public static TestEnum valueOf(String s) {
//        return (TestEnum) Enum.valueOf(TestEnum.class, s);
//    }
}
