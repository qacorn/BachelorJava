package com.class2018062805.implement03;

public class DuplicatedKeyException extends Exception {

    private String  showMessage;
    //日志打印的信息
    private String message;

    public DuplicatedKeyException(String message, String showMessage) {
        super(message);
        this.showMessage = showMessage;
        this.message = message;
    }


}
