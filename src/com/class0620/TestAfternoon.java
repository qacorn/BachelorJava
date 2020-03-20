package com.class0620;

public class TestAfternoon {

    enum Season{
        SPRING,SUMMER,AUTUMN,WINTER
    }

    public static  void  main(String[] args){
        log1();
        log2();
        log3();

        int a = 2;
        int b = 10;
        if(a*b >20){
            System.out.println("a*b>20");
        }else if (a*b==20){
            System.out.println("a*b==20");
        }else{
            System.out.println("a*b<20");
        }




        String c = a>b?"a>b":"a<=b";
        System.out.println(c);

        verifyScore();


//        String season = "2";

        Season seasonEnum = Season.SPRING;

        switch (seasonEnum) {
            case SPRING:
                System.out.println("today is spring!");
                break;
            case SUMMER:
                System.out.println("today is summer!");
                break;
            case AUTUMN:
                System.out.println("today is autumn!");
                break;
            case WINTER:
                System.out.println("today is winter!");
                break;
            default:
                System.out.println("today is none!");
                break;
        }
//        judgeSeason(seasonEnum);
        int sum =0;
        for (int i = 0; i <= 10; i++) {
            sum += i;
        }
        System.out.println(sum);

        int i= 1;
        while(i<=10){
            System.out.println(i);
            i+=1;
        }

        int j= 60;
        while(j<=100){
            if (j%2==0) {
                System.out.print(j);
                System.out.print(" ");
            }
            j++;

        }

        int k = 0;
        int sumDo = 0;
        do{
            sumDo+= k;
            k++;
        }while (k<=10);

        System.out.println("");
        System.out.println(sumDo);

    }

    private static void verifyScore() {
        int score = 79;

        if (score > 90){
            System.out.println("成绩优秀!");
        }else if (score > 70){
            System.out.println("成绩优良!");
        }else if (score > 60){
            System.out.println("成绩合格!");
        }else{
            System.out.println("成绩不合格!");
        }
    }



//    public static void judgeSeason(Season season){
//        switch (season){
//            case Season.SPRING:
//                System.out.println("today is spring!");
//                break;
//            case Season.SUMMER:
//                System.out.println("today is summer!");
//                break;
//            case Season.AUTUMN:
//                System.out.println("today is autumn!");
//                break;
//            case Season.WINTER:
//                System.out.println("today is winter!");
//                break;
//            default:
//                System.out.println("today is none!");
//                break;
//        }
//    }


    public static void log3(){
        System.out.println("log3");
    }


    public static void log2(){
        System.out.println("log2");
    }


    public static void log1(){
        System.out.println("log1");
    }




}
