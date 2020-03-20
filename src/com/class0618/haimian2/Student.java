package com.class0618.haimian2;

public class Student extends Person{


    private String school;


    public Student(String school,String name, int age) {
        super(name, age);
        setAge(18);
        if (verifySchool(school)){
            this.school = school;
            StringBuffer stringBuffer = new StringBuffer("人名:$");
            stringBuffer.append(name).append("  年龄:$").append(age).append(" 学校:$").append(school);
            System.out.println(stringBuffer.toString());
        }else{
            System.out.println("Student构造错误!");
        }
    }

    private boolean verifySchool(String school){
        return !school.equals("哈尔滨佛学院");
    }


}
