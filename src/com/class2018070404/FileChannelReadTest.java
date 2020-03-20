package com.class2018070404;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelReadTest {
    public static void main(String[] args) {
        try {
            FileChannel fileChannel = new FileInputStream("D:\\JavaIOTest\\王维.txt").getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int hasRead = 0;
            while ((hasRead = fileChannel.read(byteBuffer))>0){
                byteBuffer.flip();
                Charset charset = Charset.forName("GBK");
                CharsetDecoder charsetDecoder = charset.newDecoder();
                CharBuffer charBuffer = charsetDecoder.decode(byteBuffer);
                System.out.print(charBuffer);
                byteBuffer.clear();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
