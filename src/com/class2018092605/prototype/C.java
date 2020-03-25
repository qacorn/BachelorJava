package com.class2018092605.prototype;

public class C implements A {

    //
    private static final B b = new B();

    public A clone(){
        C c = new C();
        c.setM(b.getM());
        return c;
    }


    @Override
    public void setM(String string) {

    }

    @Override
    public String getM() {
        return "kajlkdflajldfjkl";
    }
}
