package com.class2018070404;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class ChannelCopyTest {

    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\JavaIOTest\\channelTransfer\\王维.txt","rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile("D:\\JavaIOTest\\channelTransfer\\鹿砦.txt","rw");

            FileChannel wangChannel = randomAccessFile.getChannel();
            FileChannel luChannel = randomAccessFile2.getChannel();

            long position = 0;
            long count = luChannel.size();

//            toChannel.transferFrom(fromChannel,position,count);
            luChannel.transferTo(position,count,wangChannel);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
