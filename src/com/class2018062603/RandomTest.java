package com.class2018062603;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        System.out.println("random1的第一个随机数:" + random.nextInt(100));
        System.out.println("random1的第二个随机数:" + random.nextInt(100));
        System.out.println("random1的第三个随机数:" + random.nextInt(100));


        Random random2 = new Random();
        System.out.println("random2的第一个随机数:" + random.nextInt(100));
        System.out.println("random2的第二个随机数:" + random.nextInt(100));
        System.out.println("random2的第三个随机数:" + random.nextInt(100));

//        random2.n
    }
}
