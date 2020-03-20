package com.class2018070304;

public class SingleLoopSelector implements Selector {
    @Override
    public int next(int musicListSize, int currentIndex) {
        System.out.println("单曲循环............");
        return currentIndex;
    }

    @Override
    public int previous(int musicListSize, int currentIndex) {
        return currentIndex;
    }

    @Override
    public Selector modifySelector(Selector selector) {
        return selector;
    }
}
