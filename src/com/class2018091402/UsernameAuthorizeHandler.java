package com.class2018091402;

public class UsernameAuthorizeHandler implements AuthorizeHandler{
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证用户名密码！");
        return false;
    }
}
