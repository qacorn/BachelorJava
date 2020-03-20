package com.class0618.haimian3;

public class Person extends InfoProcesor{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void verify(Object... args) {
//        System.out.println("执行Person检验器");
        if ((Integer)args[0] > 150) {
            System.out.println("构造错误，合法年龄应该在0-150之间");
            this.setInfoCorrect(false);
        } else {
            this.setInfoCorrect(true);
        }
    }

    @Override
    public void printInfo() {
        System.out.println("人名：" + this.name + ", 年龄：" + this.age);
    }

    public Person(String name, Integer age, Object... toVerifyInfoList) {
        super(toVerifyInfoList);
        if(this.getInfoCorrect()) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("请输入年龄");
        } else {
            int age = Integer.parseInt(args[0]);
            Person person = new Person("wangyajun", age);
        }
    }
}
