package com.class2018091402;

public class AliPayAuthorizeHandler implements AuthorizeHandler{
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证支付宝授权信息！");
        return false;
    }
}
