package com.exercise.exercise04code.test09;

public class Triangle implements Ishape{

    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double height;

    public Triangle(double firstSide, double secondSide, double thirdSide, double height) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double getArea() {
        return firstSide*height/2;
    }
}
