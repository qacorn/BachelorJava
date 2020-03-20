package com.class2018070504;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyThread extends Thread {

    private String sourceFileName;
    private String targetFileName;
    private long readPosition;

    public CopyThread(String sourceFileName, String targetFileName, long readPosition) {
        this.sourceFileName = sourceFileName;
        this.targetFileName = targetFileName;
        this.readPosition = readPosition;
    }

    @Override
    public void run() {
        RandomAccessFile randomReadFile = null;
        RandomAccessFile randomWriteFile = null;
        try {
             randomReadFile = new RandomAccessFile(sourceFileName,"r");
            randomReadFile.seek(readPosition);
             randomWriteFile = new RandomAccessFile(targetFileName,"w");
            randomWriteFile.seek(readPosition);
            byte[] byteBuffer = new byte[1024];
            int hasRead = 0;
            while ((hasRead = randomReadFile.read(byteBuffer))>0){
                randomWriteFile.write(byteBuffer,0,hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                randomReadFile.close();
                randomWriteFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
