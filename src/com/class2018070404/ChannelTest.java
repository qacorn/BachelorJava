package com.class2018070404;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\JavaIOTest\\iHaveADream.txt","rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(byteBuffer);
            byteBuffer.flip();

            while (byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }

            byteBuffer.clear();
            byteBuffer.compact();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
