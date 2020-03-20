package com.class062202;

import java.util.Scanner;

public class PascalTriangle {

    public static int getMaxLen(int[] n){
        int sum = 0;
        for(int i=0;i<=n.length/2;i++){
            if(n[i]>sum){
                sum = n[i];
            }
        }
        return (""+sum).length();
    }
    // 初始化填充杨辉三角
    public static void init(int[][] m) {
        m[0] = new int[]{1};	// 初始第一行
        for(int i=1;i<m.length;i++){
            m[i] = new int[i+1];
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    m[i][j] = 1;
                }else{
                    m[i][j] = m[i-1][j-1] + m[i-1][j];
                }
            }
        }
    }
    // 输出空格
    public static void printSp(int n){
        for(int i=0;i<n;i++){
            System.out.print(" ");
        }
    }
    // 示显杨辉三角
    public static void show(int[][] m) {
        int len = getMaxLen(m[m.length-1]);	// 失掉最大数的长度+1个空格
        if(len%2==0){	// 上一行下和对齐
            len += 2;	// 偶数加2
        }else{
            len += 1;	// 奇数加1
        }
        for(int i=0;i<m.length;i++){	// 输出
            printSp((m.length-i)*len/2);	// 输出(每行前)的多少空格
            for(int j=0;j<=i;j++){
                System.out.print(m[i][j]);
                printSp(len-(m[i][j]+"").length());	// 输出(数字间)的多少空格
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("输入行数(数整n):");
        int n = scan.nextInt();
        if(n<=0) return ;
        int[][] m = new int[n][];
        init(m);	// 初始化填充杨辉三角
        show(m);	// 示显杨辉三角
    }
}
