package com.class2018062601;


public class Circle {



    static class Center{
        private float x;
        private float y;

        public Center(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }
    }

    private Center center;

    private float radius;

    public Circle (float x,float y,float r){
        this.center = new Center(x,y);
        this.radius = r;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle){
            if (this.getRadius() == ((Circle) obj).getRadius()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (int) (4*this.getRadius());
    }
}
