package com.class2018091401;

public class UsernamePasswordLogin implements VerifyOauthInformation{
    @Override
    public boolean verifyOauthInfo(String oauthId, String oauthInfo, String oauthExtra) {
        return false;
    }
}
