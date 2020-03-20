package com.class2018070402;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RedirectIn {

    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\JavaIOTest\\wangwei.txt");
//            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"GBK");
            System.setIn(fileInputStream);
            Scanner scanner = new Scanner(System.in);
            scanner.useDelimiter("\r\n");
            while (scanner.hasNext()){
                if (scanner.next().equals("exit")){
                    System.exit(0);
                }else {
                    System.out.println(scanner.next());
                }
//                scanner.nex
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
