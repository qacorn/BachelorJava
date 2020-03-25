package com.class2018091403.impl;

import com.class2018091403.AuthorizeHandler;
import com.class2018091403.AuthorizeType;
import com.class2018091403.RegisterHandler;
import com.class2018091403.VerifyAuthorizeInformation;

import java.util.HashMap;
import java.util.Map;

public class AuthorizeHandlerDispatch implements RegisterHandler, VerifyAuthorizeInformation {

    private Map<AuthorizeType, AuthorizeHandler> authorizeHandlerMap = new HashMap<>(AuthorizeType.values().length);

    @Override
    public void registerNewAuthorizeHandler(AuthorizeType authorizeType, AuthorizeHandler authorizeHandler){
        authorizeHandlerMap.put(authorizeType, authorizeHandler);
    }

    @Override
    public void verifyAuthorizeInformation(AuthorizeType authorizeType, String openId, String password){
        AuthorizeHandler authorizeHandler = authorizeHandlerMap.get(authorizeType);;
        authorizeHandler.verifyAuthorizeInformation(openId, password);
    }


}
