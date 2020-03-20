package com.class2018070304;

public class LoopMusicSelector implements Selector {
    @Override
    public int next(int musicListSize, int currentIndex) {
        System.out.println("循环播放............");
        int nexIndex = 0;
        if (currentIndex == musicListSize -1){
            nexIndex = 0;
        }else{
            nexIndex = currentIndex++;
        }
        return nexIndex;
    }

    @Override
    public int previous(int musicListSize, int currentIndex) {
        int previousIndex = 0;
        if (currentIndex == 0){
            previousIndex = musicListSize -1;
        }else{
            previousIndex = currentIndex -1;
        }
        return previousIndex;
    }

    public Selector modifySelector(Selector selector){
        return selector;
    }
}
