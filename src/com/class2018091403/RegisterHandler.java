package com.class2018091403;

public interface RegisterHandler {
    //    public void registerInitHandler(){
    //        authorizeHandlerMap.put(AuthorizeType.USERNAME,new UsernameAuthorizeHandler());
    //        authorizeHandlerMap.put(AuthorizeType.EMAIL,new EmailAuthorizeHandler());
    //        authorizeHandlerMap.put(AuthorizeType.PHONE,new MobileAuthorizeHandler());
    //        authorizeHandlerMap.put(AuthorizeType.WEIBO,new WeiboAuthorizeHandler());
    //        authorizeHandlerMap.put(AuthorizeType.WECHAT,new WechatAuthorizeHandler());
    //        authorizeHandlerMap.put(AuthorizeType.ALIPAY,new AliPayAuthorizeHandler());
    //    }
    //
    void registerNewAuthorizeHandler(AuthorizeType authorizeType, AuthorizeHandler authorizeHandler);
}
