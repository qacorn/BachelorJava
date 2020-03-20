package com.exercise.exercise03code.test05;

public class InstrumentTest {

    public static void main(String[] args) {
        testPlay();
    }

    public static void testPlay(){
        Piano piano = new Piano();
        piano.play();
        Violin violin = new Violin();
        violin.play();
    }
}
