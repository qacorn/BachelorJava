package com.class0618.haimian2;

public class SuperTest {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(args[0]).append(" ").append(args[1]).append(" ").append(args[2]);
        System.out.println(stringBuffer.toString());
        Student student = new Student(args[0],args[1],Integer.parseInt(args[2]));

//        清华大学 Guanhao 30
//        人名:$Guanhao  年龄:$30 学校:$清华大学



//        清华大学 Guanhao 151
//        Person构造错误!
//                人名:$Guanhao  年龄:$151 学校:$清华大学


//        哈尔滨佛学院 Guanhao 30
//        Student构造错误!
    }
}
