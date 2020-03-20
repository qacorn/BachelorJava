package com.class2018070504;

import java.io.*;

public class MultiThreadTask {

    public static void main(String[] args) {
        File sourceFile = new File("D:\\JavaIOTest\\android-studio-ide-173.4591728-windows.zip");
        File copyUseMultiThreadFile = new File("D:\\JavaIOTest\\copyUseMultiThreadFile.zip");


        //文件大小877 MB (920,645,008 bytes)
//        copyUseFileOutput 9696
//        copyUseBufferedOutputStream 6455
//        copyUseFileOutput(sourceFile);
//        copyUseBufferedOutputStream(sourceFile);

        copyUseMultiThread();
    }

    private static void copyUseMultiThread() {
        RandomAccessFile randomAccessFile = null;
        try {

            String source = "D:\\JavaIOTest\\android-studio-ide-173.4591728-windows.zip";
            String target = "D:\\JavaIOTest\\copyUseMultiThreadFile.zip";
            File sourceFile = new File("D:\\JavaIOTest\\android-studio-ide-173.4591728-windows.zip");
            File copyUseMultiThreadFile = new File("D:\\JavaIOTest\\copyUseMultiThreadFile.zip");
            if (copyUseMultiThreadFile.exists()){
                copyUseMultiThreadFile.delete();
            }else {
                 randomAccessFile  = new RandomAccessFile("D:\\JavaIOTest\\copyUseMultiThreadFile.zip","rw");
                randomAccessFile.setLength(sourceFile.length());
            }
            int coreNumber = Runtime.getRuntime().availableProcessors();
            long fileLength = sourceFile.length();
            int byteCountEveryPart = (int) (fileLength/(coreNumber*1024)) +1;
            for (int i = 0; i < coreNumber; i++) {
                if (i==0){
                    new CopyThread(source,target,i*byteCountEveryPart).start();
                    System.out.println("i*byteCountEveryPart==" + i*byteCountEveryPart);
                }else {
                    new CopyThread(source,target,i*byteCountEveryPart+1).start();
                    System.out.println("i*byteCountEveryPart==" + (i*byteCountEveryPart+1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

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
