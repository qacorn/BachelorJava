package com.class2018070303;

public enum ApiError {
    WRONG_JSON(40099, "json格式异常"),
    WRONG_REQUEST(40010, "请求信息不正确")
    ;


    ApiError(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private Integer errorCode;
    private String errorMessage;

    public static ApiError getApiError(Integer errorCode) {
        for (ApiError apiError : values()) {
            if (apiError.getErrorCode() == errorCode) {
                return apiError;
            }
        }
        return null;
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
}
