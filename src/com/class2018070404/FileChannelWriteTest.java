package com.class2018070404;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelWriteTest {

    public static void main(String[] args) {
        try {
            FileChannel fileChannel = new FileOutputStream("D:\\JavaIOTest\\FileChannelWrite.txt").getChannel();
            String newData = "New String to write to file....." + System.currentTimeMillis();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            byteBuffer.clear();
            byteBuffer.put(newData.getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()){
                fileChannel.write(byteBuffer);
            }
            fileChannel.close();
            fileChannel.position();
            fileChannel.size();
            fileChannel.truncate(100);
            fileChannel.force(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
;
