package com.class2018062702;

public enum ApiError {

    WRONG_PASSWORD("40073","wrong_password"),
    JSON_PASSWORD("40076","wrong_password");

    private String errorCode;
    private String showMessage;

    ApiError(String errorCode, String showMessage) {
        this.errorCode = errorCode;
        this.showMessage = showMessage;
    }

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
}
