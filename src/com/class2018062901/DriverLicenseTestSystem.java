package com.class2018062901;

import java.util.Scanner;

public class DriverLicenseTestSystem {

    public static void main(String[] args) {

        printSystemTitle();
        System.out.println("请选择: 1 我是管理员, 2 我是考生 , 3 退出系统");
        Scanner scanner = new Scanner(System.in);
        String identity = scanner.nextLine();
        if (identity.equals("1")){
            System.out.println("请选择: 1 ");
        }else if (identity.equals("2")){

        }

    }

    public static void printSystemTitle() {
        System.out.println("**********************************************");
        System.out.println("*                                            *");
        System.out.println("*           科目一考试模拟系统               *");
        System.out.println("*                                            *");
        System.out.println("**********************************************");
    }
}
