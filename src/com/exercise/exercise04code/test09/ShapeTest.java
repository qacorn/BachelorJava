package com.exercise.exercise04code.test09;

public class ShapeTest {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(100,50);
        StringBuffer rectangleBuffer = new StringBuffer("长方形的周长为");
        rectangleBuffer.append(rectangle.getPerimeter()).append(",面积为").append(rectangle.getArea());
        System.out.println(rectangleBuffer.toString());

        Triangle triangle = new Triangle(3,4,5,4);
        StringBuffer triangleBuffer = new StringBuffer("三角形的周长为");
        triangleBuffer.append(triangle.getPerimeter()).append(",面积为").append(triangle.getArea());
        System.out.println(triangleBuffer.toString());

        Parallelogram parallelogram = new Parallelogram(40,30);
        StringBuffer parallelogramBuffer = new StringBuffer("平行四边形的周长为");
        parallelogramBuffer.append(parallelogram.getPerimeter()).append(",面积为").append(parallelogram.getArea());
        System.out.println(parallelogramBuffer.toString());
    }
}
