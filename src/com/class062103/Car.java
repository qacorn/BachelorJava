package com.class062103;

public class Car implements IRunner{
    public void start() {
        System.out.println("打火、挂档");
    }

    public void run() {
        System.out.println("松离合、给油 、换挡、 car 跑起来");
    }

    public void stop() {
        System.out.println("踩刹车、踩离合 car 停下来");
    }
}
