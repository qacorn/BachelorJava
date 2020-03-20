package com.class0620;

public class BlockChain {

    public static void main(String[] args){
        System.out.print("Hello world!");
        System.out.print("你好,王亚军!");
        System.out.println("wanyajun"+ " is a" + " person");


        for (int i = 0; i < 8; i++) {
            System.out.print("你好,王亚军!");
        }


        for(int i = 0;i<63;i++){

            for(int j=0;j<i/2;j++){
                System.out.print(" ");
            }
            for(int k=0;k<i;k++){
                System.out.print(args[0]);
            }

            System.out.println();
        }


        for(int i = 0;i<63;i++){

            for(int j=63/2-i;j>0;j--){
                System.out.print(" ");
            }
            for(int k=0;k<i*2;k++){
                System.out.print(args[0]);
            }

            System.out.println();
        }
    }





}
