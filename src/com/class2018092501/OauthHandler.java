package com.class2018092501;

public interface OauthHandler {
    void verifyOauthInfo(Byte OauthType, String openId, String oauthToken);

    Byte getOauthType();

    void dealOauthInfo();
}
