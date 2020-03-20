package com.class2018070304;

import java.util.Random;

public class RandomMusicSelector implements Selector {

    Random random = new Random();

    @Override
    public int next(int musicListSize, int currentIndex) {
        System.out.println("随机播放............");
        int nextIndex = random.nextInt(musicListSize);
        int randomCount = 0;
        while (nextIndex == currentIndex && randomCount <3){
            nextIndex = random.nextInt(musicListSize);
        }
        return nextIndex;
    }

    @Override
    public int previous(int musicListSize, int currentIndex) {
        int nextIndex = random.nextInt(musicListSize);
        int randomCount = 0;
        while (nextIndex == currentIndex && randomCount <3){
            nextIndex = random.nextInt(musicListSize);
        }
        return nextIndex;
    }

    @Override
    public Selector modifySelector(Selector selector) {
        return selector;
    }
}
