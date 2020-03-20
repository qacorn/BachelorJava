package com.class2018070306;

public class Test {

    private static Selector selector;

    static {
        selector = new SingleCycleSelector();
    }

    public static void modifySelector(Selector selectorToUpdate) {
        selector = selectorToUpdate;
    }

    public static void main(String[] args) {
        selector.getNextMusic(5,1);
        modifySelector(new CycleSelector());
//        modifySelector(new Selector() {
//            @Override
//            public Integer getNextMusic(int musicListSize, int currentIndex) {
//                System.out.println("Selector");
//                return 1;
//            }
//        });
        selector.getNextMusic(5,1);
    }
}
