package com.class062202;

public class YanghuiAngle {

    public static void main(String[] args) {
        printPascalTriangle();
    }

    private static void printPascalTriangle() {
        int[][]  yanghuiAngle = new int[20][];
        for (int row = 0; row < 20; row++) {
            yanghuiAngle[row] = new int[row+1];
            for (int column = 0; column < yanghuiAngle[row].length; column++) {
                if (column == 0|| row == 0) {
                    yanghuiAngle[row][column] = 1;
//                } else if (column == yanghuiAngle[row].length -1){
                }else if (column == row){
                    yanghuiAngle[row][column] = 1;
                } else {
                    yanghuiAngle[row][column] = yanghuiAngle[row-1][column-1] + yanghuiAngle[row-1][column];
                }
                System.out.print(yanghuiAngle[row][column] + "\t");
            }
            System.out.println();
        }
    }

    private static void printPerfectPascalTriangle(){
        int[][]  yanghuiAngle = new int[20][];
        for (int row = 0; row < 20; row++) {
            yanghuiAngle[row] = new int[row+1];
            for (int column = 0; column < yanghuiAngle[row].length; column++) {
                if (column == 0|| row == column) {
                    yanghuiAngle[row][column] = 1;
                }else {
                    yanghuiAngle[row][column] = yanghuiAngle[row-1][column-1] + yanghuiAngle[row-1][column];
                }
                System.out.print(yanghuiAngle[row][column] + "\t");
            }
            System.out.println();
        }
    }
}
