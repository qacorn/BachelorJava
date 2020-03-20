package com.exercise.exercise02;

public class Circle {

    private final double PI = 3.14d;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getCircumference(){
        return  2*PI*radius;
    }

    public double getArea(){
        return PI*radius*radius;
    }

    public String printCircumferenceAndArea(){
        StringBuffer stringBuffer = new StringBuffer("此圆的周长为");
        stringBuffer.append(getCircumference()).append(",面积为").append(getArea());
        System.out.println(stringBuffer.toString());
        return stringBuffer.toString();
    }

}
