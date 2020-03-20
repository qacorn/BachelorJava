package com.class2018062704;

public enum ApiError {

    WRONG_PWD("40073", "wrong password"),
    WRONG_JSON("40099", "JSON格式错误");

    private String errorCode;
    private String showMessage;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getShowMessage() {
        return showMessage;
    }

    public void setShowMessage(String showMessage) {
        this.showMessage = showMessage;
    }

    ApiError(String errorCode, String showMessage) {
        this.errorCode = errorCode;
        this.showMessage = showMessage;
    }
}
