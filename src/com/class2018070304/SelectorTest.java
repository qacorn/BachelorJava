package com.class2018070304;

public class SelectorTest {

    private  Selector selector;

    public SelectorTest(Selector selector) {
        this.selector = selector;
    }

    public static void main(String[] args) {
        Selector selector = new LoopMusicSelector();
        int next = selector.next(5, 1);
        selector = new RandomMusicSelector();
        selector.next(5,1);
//        Selector selector2 = new RandomMusicSelector();
//        selectorTest.modifySelector(selector2);
//        selector2.next(5,1);

    }


}
