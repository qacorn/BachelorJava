package com.class2018070404;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ScatteringReadsTest {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\JavaIOTest\\王维鹿砦.txt");
            FileChannel fileChannel = fileInputStream.getChannel();
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(128);
            ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
            ByteBuffer[] byteBufferArray = {byteBuffer1,byteBuffer2};
            fileChannel.read(byteBufferArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
