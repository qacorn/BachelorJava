package com.class2018091403.handler;

import com.class2018091403.AuthorizeType;

public class UsernameAuthorizeHandler extends AbstractAuthorizeHandler{
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证用户名密码！");
        return false;
    }

    @Override
    public AuthorizeType getAuthorizeType() {
        return AuthorizeType.USERNAME;
    }
}
