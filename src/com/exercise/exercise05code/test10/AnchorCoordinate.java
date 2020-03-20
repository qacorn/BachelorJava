package com.exercise.exercise05code.test10;

/**
 * Created by Michael on 8/26/2017.
 */

public class AnchorCoordinate {

    private int index;
    private int x;
    private int y;
    private int z;

    public AnchorCoordinate(int index, int x, int y, int z) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.z = z;
        System.out.println("调用AnchorCoordinate带参构造方法!");
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
