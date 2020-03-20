package com.class2018070306;

public class SingleCycleSelector implements Selector {

    @Override
    public Integer getNextMusic(int musicListSize, int currentIndex) {
        System.out.println("SingleCycleSelector");
        return currentIndex;
    }
}
