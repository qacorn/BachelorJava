package com.class2018062801;

public class Person {

    private Code code;
    private String name;

    public Person(Code code, String name) {
        this.code = code;
        this.name = name;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "com.class0620.Person{" +
                "code=" + code +
                ", name='" + name + '\'' +
                '}';
    }
}
