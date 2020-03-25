package com.class2018091403;

import com.class2018091403.handler.GitHubAuthorizeHandler;

public class Test {

    public static void main(String[] args) {

        AuthorizeType authorizeType = AuthorizeType.QQ;
        String openId = "guanhao";
        String password = "12345678";

//        AuthorizeHandlerDispatch authorizeHandlerDispatch = new AuthorizeHandlerDispatch();
//        authorizeHandlerDispatch.registerInitHandler();
//
//
//
//
//
//        authorizeHandlerDispatch.registerNewAuthorizeHandler(AuthorizeType.GITHUB,new GitHubAuthorizeHandler());
//
////        AuthorizeHandler authorizeHandler = authorizeHandlerDispatch.getAuthorizeHandler(authorizeType);
////        authorizeHandler.verifyAuthorizeInformation(openId, password);
//
//        authorizeHandlerDispatch.verifyAuthorizeInformation(AuthorizeType.GITHUB,openId,password);

        AuthorizeHandler qqAuthorizeHandler = new GitHubAuthorizeHandler();
        qqAuthorizeHandler.register();
        qqAuthorizeHandler.verifyAuthorizeInformation(openId,password);
    }
}
