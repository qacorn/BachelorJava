package com.class2018092504;

public class ShapeTest {
    public static void main(String[] args) {
        try {
            IShape circle = ShapeFactory.buildShape("Circle");
            circle.draw();
            circle.eras();
        } catch (UnSupportedShapeException e) {
            e.printStackTrace();
        }
    }
}
