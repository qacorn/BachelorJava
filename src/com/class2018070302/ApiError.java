package com.class2018070302;

public enum ApiError {
    WRONG_JSON(40099,"JSON格式异常"),
    WRONG_JSON2(40100,"JSON格式异常");
    ;

    private Integer errorCode;
    private String errorMessage;

    ApiError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public static ApiError getApiError(Integer errorCode){
//        values();
        for (ApiError apierror : values()) {
            if (apierror.getErrorCode() == errorCode){
                return apierror;
            }
        }
        return null;
    }
}
