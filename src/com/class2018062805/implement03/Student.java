package com.class2018062805.implement03;

public class Student {

    private int studentID;
    private int gradeID;
    private String name;

    public Student(int studentID, int gradeID, String name) {
        this.studentID = studentID;
        this.gradeID = gradeID;
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("该学生的ID为:").append(getStudentID()).append(" 年级为:").append(getGradeID()).append(" 姓名为:").append(getName());
        return stringBuffer.toString();
    }
}
