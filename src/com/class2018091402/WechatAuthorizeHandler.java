package com.class2018091402;

public class WechatAuthorizeHandler implements AuthorizeHandler {
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证微信授权信息！");
        return false;
    }
}
