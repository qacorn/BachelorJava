package com.class2018070809;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LitchiWarehouse {
    private int maxStock = 10;
    private final int salesAmount = 300;
    private int currentSale;


    private List<Litchi> currentLitchiList = new ArrayList<>(maxStock);

    private Object pickLock = new Object();
    private Object sellLock = new Object();

    public void pickLitchi() {

        try {
            Litchi litchi = null;
            System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 开始摘取荔枝......");
            litchi = new Litchi(0,LitchiStatus.PREPARE_PICK);
            boolean addSuccess = currentLitchiList.add(litchi);
            if (addSuccess) {
                Thread.sleep(2000L);
                System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + " 完成摘取荔枝......");
                litchi.setLitchiStatus(LitchiStatus.ADDED_TO_STOCK);
            }else{
                synchronized (pickLock) {
                    System.out.println(Thread.currentThread().getName() + "@" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date())+" 发现仓库已满,暂停摘取荔枝");
                    pickLock.wait();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void sellLitchi() {

//        for (int i = 0; i < currentLitchiList.size(); i++) {
//            if ()
//        }

        int currentLitchi = 0;
        for (Litchi litchi : currentLitchiList) {
            if (litchi.getLitchiStatus() == LitchiStatus.ADDED_TO_STOCK){
                currentLitchi ++;
            }
        }

        if (currentLitchi >0) {
            for (Litchi litchi : currentLitchiList) {
                if (litchi.getLitchiStatus() == LitchiStatus.ADDED_TO_STOCK){
                    currentLitchi ++;
                }
            }
            currentLitchiList.get(0).setLitchiStatus(LitchiStatus.GET_SELLER);
        }



    }
}
