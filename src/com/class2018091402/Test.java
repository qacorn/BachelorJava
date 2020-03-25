package com.class2018091402;

public class Test {

    public static void main(String[] args) {
        int authorizeType = 0;
        String openId = "guanhao";
        String password = "12345678";

        if (authorizeType == AuthorizeConstant.CODE_USERNAME_PASSWORD) {
            UsernameAuthorizeHandler usernameAuthorizeHandler = new UsernameAuthorizeHandler();
            usernameAuthorizeHandler.verifyAuthorizeInformation(openId, password);
        }else if (authorizeType == AuthorizeConstant.CODE_EMAIL_PASSWORD){
            EmailAuthorizeHandler emailAuthorizeHandler = new EmailAuthorizeHandler();
            emailAuthorizeHandler.verifyAuthorizeInformation(openId,password);
        } else if (authorizeType == AuthorizeConstant.CODE_WEIBO_ACCOUNT) {
            WeiboAuthorizeHandler weiboAuthorizeHandler = new WeiboAuthorizeHandler();
            weiboAuthorizeHandler.verifyAuthorizeInformation(openId, password);
        } else if (authorizeType == AuthorizeConstant.CODE_WECHAT_ACCOUNT) {
            WechatAuthorizeHandler wechatAuthorizeHandler = new WechatAuthorizeHandler();
            wechatAuthorizeHandler.verifyAuthorizeInformation(openId, password);
        } else if (authorizeType == AuthorizeConstant.CODE_ALIPAY_ACCOUNT) {
            AliPayAuthorizeHandler aliPayAuthorizeHandler = new AliPayAuthorizeHandler();
            aliPayAuthorizeHandler.verifyAuthorizeInformation(openId, password);
        }




    }
}
