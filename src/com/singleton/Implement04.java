package com.singleton;

public class Implement04 {

    //Lazy initialization holder class

    private Implement04() {

    }

    private static final Implement04 implement04 = new Implement04();

    public static Implement04 getInstance(){
        return ServiceHolder.IMPLEMENT_04;
    }

    private static class ServiceHolder{
        private static final Implement04 IMPLEMENT_04 = new Implement04();
    }


}
