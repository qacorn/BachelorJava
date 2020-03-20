package com.class2018062602;

public class StringEffective {

    private static final String base = "test";

    private static final int count = 100000000;

    public static void stringAppend(){
        long start = System.currentTimeMillis();
        String string = base;
        for (int i = 0; i < 10000; i++) {
            string += "add";
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void stringBufferAppend(){
        long start = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < count; i++) {
            stringBuffer.append("add");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void stringBuilderAppend(){
        long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append("add");
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        stringAppend();
        stringBufferAppend();
        stringBuilderAppend();

//        count = 100000000;
//        235
//        3119
//        953
    }

}
