package com.class2018062804;

public class Person {

    static class Info{
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

//    private int id;
    private Info info;
    private String name;

    public Person(Info info, String name) {
        this.info = info;
        this.name = name;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
