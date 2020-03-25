package com.class2019091001;

import java.nio.ByteBuffer;

public class ByteBufferTest {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println(byteBuffer);
        byteBuffer.put((byte) 1).put((byte) 2).put((byte) 3).put((byte) 4).put((byte) 5);
        System.out.println(byteBuffer);
        byteBuffer.flip();
        System.out.println(byteBuffer);

        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        byteBuffer.mark();
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        byteBuffer.reset();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer.get());
        System.out.println(byteBuffer);

        //读了以后释放掉
        byteBuffer.compact();

    }
}
