package com.exercise.exercise04code.test13;

public class Employee extends Person implements Add{

    private String ID;
    private double wage;
    private int workAge;

    public Employee(String name, String address, String ID, double wage, int workAge) {
        super(name, address);
        this.ID = ID;
        this.wage = wage;
        this.workAge = workAge;
    }

    @Override
    public void raiseSalary() {
        wage *= 1.1d;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getWorkAge() {
        return workAge;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    @Override
    public String toString() {
        StringBuffer employeeBuffer = new StringBuffer("员工的姓名为:");
        employeeBuffer.append(this.getName()).append(",住址为:").append(this.getAddress()).append(",ID为:").append(this.getID()).append(",薪水为:").append(this.getWage()).append(",工龄为:").append(this.getWorkAge());
        return employeeBuffer.toString();
    }
}
