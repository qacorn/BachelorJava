package com.class2018091402;

public interface AuthorizeHandler {

    boolean verifyAuthorizeInformation(String openId, String authorizeToken);

}
