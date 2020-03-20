package com.class2018070304;

public interface Selector {

    int next(int musicListSize, int currentIndex);
    int previous(int musicListSize, int currentIndex);

    Selector modifySelector(Selector selector);
}
