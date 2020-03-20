package com.class2018062802;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentSort {

    public static void main(String[] args) {
        Student student = new Student(170);
        Student student2 = new Student(175);
        Student student3 = new Student(150);
        Student student4 = new Student(160);
        Student student5 = new Student(180);
        Student student6 = new Student(190);
        Student student7 = new Student(210);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
//        studentList.sort(new StudentComparator());

        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //按自然顺序排列，返回正值1
                //按升序排列
                if (o1.getHeight() > o2.getHeight()){
                    return 1;
                }else if (o1.getHeight() < o2.getHeight()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getHeight());
        }

    }
}
