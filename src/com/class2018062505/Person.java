package com.class2018062505;

import java.util.Date;

public class Person {
    private Long userId;
    private String name;
    private Integer age;
    private String schoolName;
    private Date outTime;

    static class InnerDate{
        public static final Object[] DATA = {};
    }

    public Object[] fetchData() {
        Object[] objects = new Object[5];
        objects[0] = 618L;
        objects[1] = "wangyajun";
        objects[2] = 30;
        objects[3] = "JLU";
        objects[4] = new Date(1949, 10, 1);
        return objects;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }
}
