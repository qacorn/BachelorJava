package com.class2018070401;

import java.io.*;

public class WriteTest {

    public static void main(String[] args) {
        File  file = new File("D:\\JavaIOTest\\charStream.txt");
        try {

            FileOutputStream fileOutputStream = new FileOutputStream(file,true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");
            outputStreamWriter.write("开元二十四年（736年），调任监察御史，后奉命出塞，担任凉州河西节度幕判官。");
            outputStreamWriter.flush();



            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
            char[] charBuffer = new char[32];
            int hasRead = 0;
            while ((hasRead = inputStreamReader.read(charBuffer))>0) {
                System.out.println(hasRead);
                System.out.println(new String(charBuffer,0,hasRead));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
;