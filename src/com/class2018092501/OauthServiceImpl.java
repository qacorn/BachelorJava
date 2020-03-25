package com.class2018092501;

import java.util.HashMap;
import java.util.Map;

public class OauthServiceImpl implements OauthService,OauthRegisterService {

    private Map<Byte, OauthHandler> oauthHandlerMap = new HashMap<>(8);

    @Override
    public void registerHandler(Byte oauthType, OauthHandler oauthHandler) {
        oauthHandlerMap.put(oauthType, oauthHandler);
    }

    @Override
    public void verifyOauthInfo() {

    }
}
