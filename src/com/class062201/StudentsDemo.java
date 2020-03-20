package com.class062201;

import java.util.Arrays;
import java.util.Scanner;

public class StudentsDemo {

    public static void main(String[] args) {
        // 扫描对象
        Scanner scanner = new Scanner(System.in);
        //提示输入录入学生的人数
        System.out.println("请输入录入学生的人数");
        //扫描输入的学生的人数
        String snum = scanner.nextLine();
        //转换成数字
        int num = Integer.parseInt(snum);
        //创建数组
        int arr[]=new int[num];
        System.out.println("请输入"+num+"位学生的成绩");
        //遍历数组
        for(int i=0;i<num;i++){
            //接受输入的学生成绩
            String score = scanner.nextLine();
            //初始化赋值
            arr[i]=Integer.parseInt(score);
        }

        //数组排序
        Arrays.sort(arr);
        //获取最高的成绩5
        int maxScore = arr[num-1];
        System.out.println("学生等级划分结果");
        //遍历数组
        for(int i=0;i<num;i++){
            if(arr[i]>maxScore-10){
                System.out.println(arr[i]+"等级为A");
            }else if(arr[i]>maxScore-20){
                System.out.println(arr[i]+"等级为B");
            }else if(arr[i]>maxScore-30){
                System.out.println(arr[i]+"等级为C");
            }else{
                System.out.println(arr[i]+"等级为D");
            }
        }
    }

}
