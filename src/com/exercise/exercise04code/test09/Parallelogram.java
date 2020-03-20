package com.exercise.exercise04code.test09;

public class Parallelogram implements Ishape{

    private double side;
    private double height;

    public Parallelogram(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    public double getPerimeter() {
        return 4*side;
    }

    @Override
    public double getArea() {
        return side*height;
    }
}
