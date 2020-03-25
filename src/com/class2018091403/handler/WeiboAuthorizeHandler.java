package com.class2018091403.handler;

import com.class2018091403.AuthorizeType;

public class WeiboAuthorizeHandler extends AbstractAuthorizeHandler {
    @Override
    public boolean verifyAuthorizeInformation(String openId, String authorizeToken) {
        System.out.println("正在验证新浪微博授权信息！");
        return false;
    }

    @Override
    public AuthorizeType getAuthorizeType() {
        return AuthorizeType.WEIBO;
    }
}
