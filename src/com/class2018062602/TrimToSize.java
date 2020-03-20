package com.class2018062602;

public class TrimToSize {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer(" java stringbuffer ");
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.capacity());

        stringBuffer.trimToSize();

        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer.capacity());
    }
}
