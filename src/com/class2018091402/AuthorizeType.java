package com.class2018091402;

public enum AuthorizeType {

    USERNAME(AuthorizeConstant.CODE_USERNAME_PASSWORD,AuthorizeConstant.AUTH_CHECK_TYPE_PASSWORD,"用户名密码"),
    EMAIL(AuthorizeConstant.CODE_EMAIL_PASSWORD,AuthorizeConstant.AUTH_CHECK_TYPE_PASSWORD,"邮箱密码"),
    PHONE(AuthorizeConstant.CODE_PHONE_PASSWORD,AuthorizeConstant.AUTH_CHECK_TYPE_PASSWORD,"手机密码"),
    QQ(AuthorizeConstant.CODE_QQ_ACCOUNT,AuthorizeConstant.AUTH_CHECK_TYPE_PASSWORD,"QQ授权"),
    WEIBO(AuthorizeConstant.CODE_WEIBO_ACCOUNT,AuthorizeConstant.AUTH_CHECK_TYPE_PASSWORD,"新浪微博授权"),
    WECHAT(AuthorizeConstant.CODE_WECHAT_ACCOUNT,AuthorizeConstant.AUTH_CHECK_TYPE_PASSWORD,"微信授权"),
    ALIPAY(AuthorizeConstant.CODE_ALIPAY_ACCOUNT,AuthorizeConstant.AUTH_CHECK_TYPE_PASSWORD,"支付宝授权");

    private Byte typeCode;
    private String checkType;
    private String typeName;

    AuthorizeType(Byte typeCode, String checkType, String typeName) {
        this.typeCode = typeCode;
        this.checkType = checkType;
        this.typeName = typeName;
    }

    public Byte getTypeCode() {
        return typeCode;
    }

    public String getCheckType() {
        return checkType;
    }

    public String getTypeName() {
        return typeName;
    }
}
