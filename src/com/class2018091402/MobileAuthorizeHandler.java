package com.class2018091402;

public class MobileAuthorizeHandler implements AuthorizeHandler {
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证手机号密码！");
        return false;
    }
}
