package com.class2018070401;

import java.io.*;

public class EncodingTest {

    public static void main(String[] args) {
        File flie = new File("D:\\JavaIOTest\\jgakjg.txt");

        try {
            FileInputStream fileInputStream = new FileInputStream(flie);
            byte[] bytesBuffer = new byte[1024];
            int hasRead = 0;

            while ((hasRead = fileInputStream.read(bytesBuffer))>0){
                System.out.println(new String(bytesBuffer,"GBK"));
            }



//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            inputStreamReader.getEncoding();
            System.out.println(inputStreamReader.getEncoding());
            char[] chars = new char[(int) flie.length()];
            inputStreamReader.read(chars);
            System.out.println(new String(chars));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
