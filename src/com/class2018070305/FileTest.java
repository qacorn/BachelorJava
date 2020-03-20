package com.class2018070305;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        String fileName = "D:\\790004JavaBook";

        liseFile(fileName);
    }

    public static void liseFile(String fileName) {
        File  file = new File(fileName);
        if (file.isDirectory()) {
            String[] firstFileName = file.list();
            for (String name : firstFileName) {
                System.out.println(name);
                String secondaryFile = fileName + name;
                File fileSecondary = new File(secondaryFile);
                if (fileSecondary.isFile()) {

                } else if (fileSecondary.isDirectory()) {
//                    String[] secondaryFileName = fileSecondary.list();
//                    for (String nameSecondary : secondaryFileName) {
//                        System.out.println("--------" + nameSecondary);
//                    }
                    liseFile(secondaryFile);
                }
            }
        }
    }
}
