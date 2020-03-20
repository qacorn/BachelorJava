package com.exercise.exercise05code.test01;

public class ArrayTest {

    /**
     * . 写一个程序要求将一个整型数组中的0去掉，返回一个新数组。
     *   例如数组int[] arr={1,13,45,5,0,0,16,6,0,25,4,17,6,7,0,15};，将不为0的数值存入一个新数组，
     *   int[] newArr={1,13,45,5,16,6,25,4,17,6,7,15};
     * @param args
     */

    public static void main(String[] args) {
        removeZero();
    }

    public static void removeZero(){
        int[] arr={1,13,45,5,0,0,16,6,0,25,4,17,6,7,0,15};
        int newLength = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                newLength --;
            }
        }

        int[] newArray = new int[newLength];
        int copyIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0){
                newArray[copyIndex] = arr[i];
                copyIndex++;
            }
        }

        for (int i = 0; i < newLength; i++) {
            System.out.print(newArray[i] + "    ");
        }
    }
}
