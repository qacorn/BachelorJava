package com.class2018091402;

public class WeiboAuthorizeHandler implements AuthorizeHandler {
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证新浪微博授权信息！");
        return false;
    }
}
