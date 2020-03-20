package com.class2018070402;

import java.io.*;

public class SequenceInputStreamTest {

    public static void main(String[] args) {

        try {
            FileInputStream fileInputStream1 = new FileInputStream("D:\\JavaIOTest\\王维.txt");
            FileInputStream fileInputStream2 = new FileInputStream("D:\\JavaIOTest\\鹿砦.txt");
            FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaIOTest\\王维鹿砦.txt");
            SequenceInputStream sequenceInputStream = new SequenceInputStream(fileInputStream1,fileInputStream2);
            int hasRead = 0;
            while ((hasRead = sequenceInputStream.read())!=-1){
                fileOutputStream.write(hasRead);
            }

            sequenceInputStream.close();
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
