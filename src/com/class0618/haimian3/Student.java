package com.class0618.haimian3;

public class Student extends Person {

    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public void verify(Object... args) {
        super.verify(args[0]);
        if (this.getInfoCorrect()) {
            if ("哈尔滨佛学院".equals(args[1])) {
                System.out.println("构造错误，不存在的学校");
                this.setInfoCorrect(false);
            } else {
                this.setInfoCorrect(true);
            }
        }
    }

    @Override
    public void printInfo() {
        System.out.println("人名：" + this.getName() + ", 年龄：" + this.getAge() + ", 学校：" + this.getSchool());
    }

    public Student(String name, Integer age, String school) {
        super(name, age, age, school);
        if (this.getInfoCorrect()) {
            this.school = school;
            printInfo();
        }
    }

    public static void main(String[] args) {
        Student student = new Student("王亚军", 18, args[0]);
    }
}
