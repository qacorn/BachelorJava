package com.class2018070404;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestNIO {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\JavaIOTest\\王维鹿砦","rw");
            FileChannel fileChannel = randomAccessFile.getChannel();

//            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(byteBuffer);
            byteBuffer.flip();

            byteBuffer.hasRemaining();

//            fileChannel.
            System.out.println(byteBuffer.get(0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
