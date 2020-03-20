package com.exercise.exercise03code.test01;

public class Student {

    private int ID;
    private String name;
    private int score;

    public Student(int ID, String name, int score) {
        this.ID = ID;
        this.name = name;
        this.score = score;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
