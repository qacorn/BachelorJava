package com.exercise.exercise04code.test10;

public class InstrumentTest {


    private void  playInstrument(Instrument ins){
        ins.play();
    }

    class MemberInnerClass implements Instrument{

        @Override
        public void play() {
            System.out.println("MemberInnerClass play Instrument");
        }
    }

    static class  StaticInnerClass implements Instrument{

        @Override
        public void play() {
            System.out.println("StaticInnerClass play Instrument");
        }
    }

    static String nameG = "Guaao";


    public static void main(String[] args) {
        InstrumentTest instrumentTest = new InstrumentTest();
        //成员内部类
        MemberInnerClass memberInnerClass = instrumentTest.new MemberInnerClass();
        instrumentTest.playInstrument(memberInnerClass);
        String name = "Guaao";
        //局部内部类
        class  LocalInnerClass implements Instrument{

            @Override
            public void play() {
                System.out.println("LocalInnerClass play Instrument");
                //
                System.out.println(nameG);
            }
        }
        LocalInnerClass localInnerClass = new LocalInnerClass();
        instrumentTest.playInstrument(localInnerClass);

        //静态内部类
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        instrumentTest.playInstrument(staticInnerClass);

        //匿名内部类
        instrumentTest.playInstrument(new Instrument() {
            @Override
            public void play() {
                System.out.println("AnonymousInnerClass play Instrument");
            }
        });
    }
}
