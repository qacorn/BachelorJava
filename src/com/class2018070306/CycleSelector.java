package com.class2018070306;

public class CycleSelector implements Selector {

    @Override
    public Integer getNextMusic(int musicListSize, int currentIndex) {
        System.out.println("CycleSelector");
        int nextIndex = currentIndex + 1;
        if (nextIndex >= musicListSize - 1) {
            nextIndex = 0;
        }
        return nextIndex;
    }
}
