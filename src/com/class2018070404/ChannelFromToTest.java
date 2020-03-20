package com.class2018070404;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelFromToTest {

    public static void main(String[] args) {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\JavaIOTest\\channelTransfer\\王维.txt","rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("D:\\JavaIOTest\\channelTransfer\\鹿砦.txt","rw");

            FileChannel fromChannel = randomAccessFile.getChannel();
            FileChannel toChannel = randomAccessFile2.getChannel();

            long position = 0;
            long count = fromChannel.size();

            toChannel.transferFrom(fromChannel,position,count);
            fromChannel.transferTo(position,fromChannel.size(),toChannel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileChannel fileChannel;
//        fileChannel.transferFrom(chan,0,0)

    }
}
