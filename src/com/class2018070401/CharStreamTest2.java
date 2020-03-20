package com.class2018070401;

import java.io.*;

public class CharStreamTest2 {

    public static void main(String[] args) {
        File file = new File("D:\\JavaIOTest\\charStream.txt");
        try {

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(", \"transitory, not durable,\" from Latin transientem (nominative transiens) \"passing over or away,\" present participle of transire \"cross over, go over, pass over, hasten over, pass away,\" from trans \"across, beyond\" (see trans-) + ire \"to go\" (from PIE root *ei- \"to go\"). Meaning \"passing through a place without staying\" is from 1680s. The noun is first attested 1650s; specific sense of \"transient guest or boarder\" attested from 1857. Related: Transiently.");
            outputStreamWriter.flush();

            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            char[] charBuffer = new char[32];
            int hasRead = 0;
            while ((hasRead = inputStreamReader.read(charBuffer))>0) {
//                System.out.println(hasRead);
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
