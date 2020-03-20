package com.class2018070305;

import java.io.*;

public class BufferedInputStreamTest {
    public static void main(String[] args) {
        File file  = new File("D:\\TDownload\\javatest.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            bufferedOutputStream.write("我爱中国".getBytes());

            fileOutputStream.write("我爱中国".getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }

        InputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);

//            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream,1024);
//            byte[] byteBuffer = new byte[1024];
//            bufferedInputStream.read(byteBuffer);
            byte[] byteBuffer = new byte[1024];
            fileInputStream.read(byteBuffer);
            System.out.println(new String(byteBuffer));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
