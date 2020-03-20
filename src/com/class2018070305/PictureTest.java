package com.class2018070305;

import java.io.*;

public class PictureTest {

    public static void main(String[] args) {

//        File file = new File("D:\\JavaIOTest\\02.jpg");
//        copyUseFileOutput 8
//        copyUseBufferedOutputStream 9
//        File file  = new File("D:\\JavaIOTest\\qianlijiangshan.jpg");
//        copyUseFileOutput 15
//        copyUseBufferedOutputStream 12
        File file = new File("D:\\JavaIOTest\\android-studio-ide-173.4591728-windows.zip");
        //文件大小877 MB (920,645,008 bytes)
//        copyUseFileOutput 9696
//        copyUseBufferedOutputStream 6455
        copyUseFileOutput(file);
        copyUseBufferedOutputStream(file);
    }

    public static void copyUseFileOutput(File file) {
        long start = System.currentTimeMillis();
        File copyUseFileOutput = new File("D:\\JavaIOTest\\copyUseFileOutput.jpg");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(copyUseFileOutput);
            byte[] byteBuffer = new byte[1024];
            int read = 0;
            while ((read = fileInputStream.read(byteBuffer)) > 0) {
                fileOutputStream.write(byteBuffer,0,read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("copyUseFileOutput " + (end - start));
    }

    public static void copyUseBufferedOutputStream(File file) {
        long start = System.currentTimeMillis();
//        File file  = new File("D:\\JavaIOTest\\02.jpg");
        File copyUseBufferedOutputStream = new File("D:\\JavaIOTest\\copyUseBufferedOutputStream.jpg");
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream, 1024);
            FileOutputStream fileOutputStream = new FileOutputStream(copyUseBufferedOutputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);

            byte[] byteBuffer = new byte[1024];
            int read = 0;
            while ((read = bufferedInputStream.read(byteBuffer)) > 0) {
                bufferedOutputStream.write(byteBuffer,0,read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("copyUseBufferedOutputStream " + (end - start));
    }

}
