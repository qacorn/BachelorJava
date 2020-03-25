package com.class2018091403.handler;

import com.class2018091403.AuthorizeHandler;
import com.class2018091403.impl.AuthorizeHandlerDispatch;

public abstract class AbstractAuthorizeHandler implements AuthorizeHandler {

    @Override
    public void register(){
        AuthorizeHandlerDispatch authorizeHandlerDispatch = new AuthorizeHandlerDispatch();
        authorizeHandlerDispatch.registerNewAuthorizeHandler(getAuthorizeType(),this);
    }



}
