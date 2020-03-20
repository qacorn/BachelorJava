package com.class2018062503;

public class PrintService {

    public static String name = "惠普";

    private static final PrintService printServiceInstance = new PrintService();
//
    public static PrintService getInstance() {
        return ServiceHolder.PRINT_SERVICE;
    }

    static class ServiceHolder{
        public static final PrintService PRINT_SERVICE = new PrintService();
    }

    private PrintService() {}

//    public static PrintService getInstence(){
//        return ServiceHolder.PRINT_SERVICE;
//    }
//

    public int getReadNum(int actualReadNum) {
        if (actualReadNum < 60) {
            return actualReadNum * actualReadNum;
        } else {
            return 3600 + actualReadNum;
        }
    }


}
