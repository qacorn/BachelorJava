package com.class0620;

public class OOMTest {

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     * 	at com.class0620.OOMTest.main(com.class0620.OOMTest.java:4)
     * @param args
     */
    public static void main(String[] args) {
        PersonThree[] people = new PersonThree[1000000000];

        for (int i = 0; i < 1000000000; i++) {
//            people = new com.class0620.Person();
            people[i] = new PersonThree();
        }
    }
}
