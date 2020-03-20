package com.exercise.exercise04code.test13;

public class Manager extends Employee implements Add{

    private String level;

    public Manager(String name, String address, String ID, double wage, int workAge, String level) {
        super(name, address, ID, wage, workAge);
        this.level = level;
    }

    @Override
    public void raiseSalary() {
        setWage(getWage()*1.2d);
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuffer employeeBuffer = new StringBuffer("经理的姓名为:");
        employeeBuffer.append(this.getName()).append(",住址为:").append(this.getAddress()).append(",ID为:").append(this.getID()).append(",薪水为:").append(this.getWage()).append(",工龄为:").append(this.getWorkAge()).append(",级别为:").append(this.getLevel());
        return employeeBuffer.toString();
    }
}
