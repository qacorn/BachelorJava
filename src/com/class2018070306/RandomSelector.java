package com.class2018070306;

import java.util.Random;

public class RandomSelector implements Selector {

    private static final Random random = new Random();

    @Override
    public Integer getNextMusic(int musicListSize, int currentIndex) {
        System.out.println("RandomSelector");
        int nextIndex = random.nextInt(musicListSize);
        int loopTime = 0;
        while (nextIndex == currentIndex && loopTime < 3) {
            nextIndex = random.nextInt(musicListSize);
            loopTime ++;
        }
        return nextIndex;
    }
}
