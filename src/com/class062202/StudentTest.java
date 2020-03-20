package com.class062202;

import java.util.Scanner;

public class StudentTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学生个数:");

        String count = scanner.nextLine();
        System.out.println(count);

        System.out.println("请输入学生成绩:");


        int studentCount = Integer.parseInt(count);
        int[] scoreArray = new int[studentCount];
        for (int i = 0; i <studentCount; i++) {
            String score = scanner.nextLine();
            scoreArray[i] = Integer.parseInt(score);
        }

        boolean exchange = false;
        for (int i = 1; i < scoreArray.length; i++) {
            exchange = false;
            for (int j = 0; j < scoreArray.length - i; j++) {
                if (scoreArray[j] < scoreArray[j+1]){
                    int temp = scoreArray[j];
                    scoreArray[j] = scoreArray[j+1];
                    scoreArray[j+1] = temp;
                    exchange = true;
                }
            }

            if (!exchange){
                break;
            }
        }

        //考虑并列的情况

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("第一名为").append(scoreArray[0]).append(",第二名为").append(scoreArray[1]).append(",第三名为").append(scoreArray[2]);
        System.out.println(stringBuffer.toString());
    }
}
