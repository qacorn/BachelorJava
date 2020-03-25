package com.class2018092610Singleton;

public class SingleLockVolatile {

    private static volatile SingleLockVolatile singleLockVolatile;

    private SingleLockVolatile() {

    }

    private static SingleLockVolatile getInstance() {
        synchronized (SingleLockVolatile.class) {
            if (null == singleLockVolatile) {
                singleLockVolatile = new SingleLockVolatile();
            }
        }
        return singleLockVolatile;
    }


}
