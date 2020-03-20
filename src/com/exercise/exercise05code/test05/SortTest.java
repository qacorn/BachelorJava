package com.exercise.exercise05code.test05;

import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        int[] intArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < intArray.length ; i++) {
            intArray[i] = random.nextInt();
        }


        boolean exchange = false;
        for (int i = 1; i < intArray.length; i++) {
            exchange = false;
            for (int j = 0; j < intArray.length - i; j++) {
                if (intArray[j] < intArray[j+1]){
                    int temp = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = temp;
                    exchange = true;
                }
            }

            if (!exchange){
                System.out.println("排序结束!");
                break;
            }else{
//                System.out.print(intArray);
                //[I@6d1e7682
                for (int j = 0; j < intArray.length; j++) {
                    System.out.print(intArray[j] + "   ");
                }
                System.out.println();
            }

        }

    }
}
