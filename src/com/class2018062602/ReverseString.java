package com.class2018062602;

public class ReverseString {

    /**
     * 三种方式实现字符串反转
     * @param args
     */

    public static void main(String[] args) {

        String string = "wangyajun";

        //
        char[] reverseArray = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            reverseArray[i] = string.charAt(string.length()-1-i);
        }
        System.out.println(new String(reverseArray));


        //
        char[] chars = string.toCharArray();
        for (int i = 0; i < string.length()/2-1; i++) {
            char temp = chars[i];
            chars[i] = chars[string.length() -1 -i];
            chars[string.length()-1 -i] = temp;
        }
        System.out.println(new String(chars));

        //
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.reverse();

    }
}
