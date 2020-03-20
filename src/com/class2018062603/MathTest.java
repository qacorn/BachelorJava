package com.class2018062603;

public abstract class MathTest {

    public static void main(String[] args) {
            Math.random();

    }

    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
}
