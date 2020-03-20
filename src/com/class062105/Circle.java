package com.class062105;

public class Circle {
    private double radius = 0;
    public static int count = 1;

    public Circle(double radius) {
        this.radius = radius;
    }

    class Draw{
        public void drawShape(){
            System.out.println(radius);
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        Circle circle = new Circle(2);
        Draw draw = circle.new Draw();
//        Circle.Draw drawQ = new Draw();
        draw.drawShape();
    }
}

