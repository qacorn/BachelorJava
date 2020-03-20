package com.class2018062701;

import java.util.Random;

public class RandomGuess {

    public static void main(String[] args) {

        int guanhao = 10000000;
        int guessCount = 0;

        Random random = new Random();
        int targetInt = random.nextInt(guanhao);
        int guessNumber =0;
        System.out.println("targetInt ==" + targetInt);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Random random2 = new Random();

        long start = System.currentTimeMillis();
        boolean guess = false;
        while (!guess){
            guessNumber = random2.nextInt(guanhao);
            System.out.println("guessNumber" + guessNumber);
            guessCount ++;
            if (guessNumber == targetInt){
                guess = true;
            }
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);
        System.out.println(guessCount);

    }
}
