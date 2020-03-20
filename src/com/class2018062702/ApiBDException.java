package com.class2018062702;

public class ApiBDException extends Exception {

    private String errorCode;
    //给用户看的
    private String  showMessage;
    //日志打印的信息
    private String message;
    private Boolean needPrintStack;

    public ApiBDException(String errorCode, String showMessage, String message, Boolean needPrintStack) {
        super(showMessage);
        this.errorCode = errorCode;
        this.showMessage = showMessage;
        this.message = message;
        this.needPrintStack = needPrintStack;
    }

    public ApiBDException(String errorCode, String showMessage, String message) {
        //访问父类的构造器
        this(errorCode,showMessage,message,true);
    }

    public ApiBDException(String errorCode, String showMessage) {
        //访问父类的构造器
        this(errorCode,showMessage,showMessage,true);
    }



    @Override
    public String getMessage() {
        return message;
    }






}
