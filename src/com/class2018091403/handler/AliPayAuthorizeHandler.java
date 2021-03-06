package com.class2018091403.handler;

import com.class2018091403.AuthorizeType;

public class AliPayAuthorizeHandler extends AbstractAuthorizeHandler{
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证支付宝授权信息！");
        return false;
    }

    @Override
    public AuthorizeType getAuthorizeType() {
        return AuthorizeType.ALIPAY;
    }
}
