package com.class2018062602;

public class StringTest {

    public static void main(String[] args) {
        //不存在常量池中
        String a1 = new String("a");
        String a2 = new String("a");
        String a3 = "a";
        String a4 = "a";

        System.out.println(a1 == a2);
        System.out.println(a3 == a4);
        System.out.println(a3 == a1);

        System.out.println("a".compareTo("z"));
        //-25   a<z

        System.out.println(a4.intern());


        String s1 = "change";
        String s2 = "java";
        String s4 = "java";
        String s3 = new String("java");
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println(s2.equals(s3));


        String s5 = "changejava";
        String s6 = (s1 + s2).intern(); //去掉.intern()方法之后看输出
        String s7 = (s1 + s2); //去掉.intern()方法之后看输出
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s5.equals(s6));
    }
}
