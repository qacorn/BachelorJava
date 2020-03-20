package com.class062202;

public class TwoDimensionArray {

    public static void main(String[] args) {
        int[][] a = new int[5][];
        a[0] = new int[5];
        a[1] = new int[5];

        for (int[] m : a) {

        }

        for (int i = 0; i < a.length; i++) {
            a[i] = new int[2*i+1];
            for (int j = 0; j < a[i].length; j++) {
//                a[i][j] =
            }
        }
    }
}
