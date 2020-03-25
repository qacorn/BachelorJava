package com.class2018092501;

public abstract class AbstractOauthHandler implements OauthHandler {


    private OauthRegisterService oauthRegisterService;

    private void register() {
        oauthRegisterService.registerHandler(this.getOauthType(),this);
    }
}
