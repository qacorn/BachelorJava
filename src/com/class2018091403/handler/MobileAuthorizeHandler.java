package com.class2018091403.handler;

import com.class2018091403.AuthorizeType;

public class MobileAuthorizeHandler extends AbstractAuthorizeHandler {
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证手机号密码！");
        return false;
    }

    @Override
    public AuthorizeType getAuthorizeType() {
        return AuthorizeType.PHONE;
    }
}
