package com.class062108;

public class Employee {

//    private CallBackInterface mCallBackInterface;
//
//    public Employee(CallBackInterface callBackInterface){
//        this.mCallBackInterface=callBackInterface;
//    }

    public void doSome(CallBackInterface callBackInterface){
        for(int i=0;i<10;i++){
            System.out.println("进度:"+i);
            if(i==9){
                System.out.println("员工：完成了");
            }
        }
//        boss.tellMe();
//        mCallBackInterface.execute();
        callBackInterface.tellMe();
    }

    public void doSome(CallBack2 callBack2){
        callBack2.addChopstick();
    }

    public void doSome(BringSauce bringSauce){
        bringSauce.bringLaoGanMaChiliCrispSauce();
    }

    public void doSome(OpenAirControl openAirControl){
        openAirControl.openAirControl();
    }
}
