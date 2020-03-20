package com.exercise.exercise05code.test10;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {

    public static void main(String[] args) {
        try {
            Class classTest = Class.forName("com.exercise.exercise05code.test10.AnchorCoordinate");
            Constructor[] constructors = classTest.getConstructors();
            AnchorCoordinate  anchorCoordinate  = (AnchorCoordinate) constructors[0].newInstance(15, 220, 456, 337);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
