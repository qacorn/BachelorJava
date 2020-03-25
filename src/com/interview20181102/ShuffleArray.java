package com.interview20181102;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleArray {

    public static void main(String[] args) {
        int[] sortArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        shuffleArray(sortArray);

        for (int i = 0; i < sortArray.length; i++) {
            System.out.println(sortArray[i]);
        }

        int[] sortArraySecond = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        shuffleSecond(sortArraySecond);

    }

    public static void shuffleArray(int[] sortArray) {
        Random random = new Random();
        for (int i = 0; i < sortArray.length; i++) {
            int temp = sortArray[i];
            int nextInt = random.nextInt(sortArray.length );
            sortArray[i] = sortArray[nextInt];
            sortArray[nextInt] = temp;
        }

    }

    public static void shuffleSecond(int[] sortArray) {
        List<int[]> ints = Arrays.asList(sortArray);
        Collections.shuffle(ints);

        for (int i = 0; i < ints.size(); i++) {
            System.out.println(ints.get(i));
        }
    }
}
