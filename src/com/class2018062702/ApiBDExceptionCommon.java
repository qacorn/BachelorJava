package com.class2018062702;

public class ApiBDExceptionCommon extends Exception {

    private ApiError apiError;
    private String message;
    private Boolean needPrintStack;

    public ApiBDExceptionCommon( ApiError apiError, String message, Boolean needPrintStack) {
        super(message);
        this.apiError = apiError;
        this.message = message;
        this.needPrintStack = needPrintStack;
    }

    public ApiBDExceptionCommon( ApiError apiError, String message) {
        this(apiError,message,true);
    }

    public ApiBDExceptionCommon(ApiError apiError) {
        this(apiError,apiError.getShowMessage(),true);
    }

}
