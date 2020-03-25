package com.class2018091401;

public class EmailPasswordLogin implements VerifyOauthInformation{
    @Override
    public boolean verifyOauthInfo(String oauthId, String oauthInfo, String oauthExtra) {
        return false;
    }
}
