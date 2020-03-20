package com.exercise.exercise03code.test03;

public class Student extends Person {

    private int ID;

    public Student(String name, int sex) {
        super(name, sex);
    }

    public Student(String name, int sex, int ID) {
        super(name, sex);
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
