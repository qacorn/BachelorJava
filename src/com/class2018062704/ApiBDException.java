package com.class2018062704;

public class ApiBDException extends Exception {
    private ApiError apiError;
    private String message;
    private Boolean needPrintStack;

//    @Override
//    public String getMessage() {
//        return this.showMessage;
//    }

    public ApiBDException(ApiError apiError, String message, Boolean needPrintStack) {
//        super(showMessage);
        this.apiError = apiError;
        this.message = message;
        this.needPrintStack = needPrintStack;
    }

    public ApiBDException(ApiError apiError) {
        this(apiError, apiError.getShowMessage());
    }

    public ApiBDException(ApiError apiError, String showMessage) {
        this(apiError, showMessage, true);
    }
}
