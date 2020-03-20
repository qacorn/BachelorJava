package com.class2018070602;

public class PrintTask implements Runnable {

    private int i = 0;

    public synchronized void test() {
        for (; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
        }
    }

    public void test02() {
//        try {
//            synchronized (i){
//                while (i <10){
//                    i++;
//                    System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
//                    i.wait();
//                }
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public void test03() {
        try {
            while (true) {
                synchronized (this) {
                    if (i < 10) {
                        i++;
                        System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
                        this.notify();
                        this.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void test04() {
        try {
            while (true) {
                synchronized (this) {
                    if (i < 10) {
                        System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
                    } else {
                        break;
                    }
                    i++;
                    this.notify();
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void test05() {
        try {
            while (true) {
                synchronized (this) {
                    if (i < 10) {
                        System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
                    } else {
                        this.notify();
                        break;
                    }
                    i++;
                    this.notify();
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void test06() {
        try {
            while (true) {
                synchronized (this) {

                    this.notify();
                    if (i < 10) {
                        System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
                    } else {

                        break;
                    }
                    i++;

                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    //优化写法

    private Object iLock = new Object();

    public void test07() {
        try {
            while (true) {
                synchronized (iLock) {
                    if (i < 10) {
                        System.out.println(Thread.currentThread().getName() + "打印第" + i + "次");
                    } else {
                        iLock.notify();
                        break;
                    }
                    i++;
                    iLock.notify();
                    iLock.wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
//        test03();
        test07();
    }
}
