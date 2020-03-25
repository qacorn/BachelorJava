package com.class2018091403;

public interface AuthorizeHandler {

    boolean verifyAuthorizeInformation(String openId, String authorizeToken);

    AuthorizeType getAuthorizeType();

    void register();

}
