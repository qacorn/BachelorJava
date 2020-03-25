package com.class2018091402;

public class EmailAuthorizeHandler implements AuthorizeHandler {
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证邮箱密码！");
        return false;
    }
}
