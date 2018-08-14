package com.leapstack.security.adapter.config.constants.enums;

public enum ResponseCommonCode {

    SUCCESS("000000", "成功"),
    BAD_REQUEST("004000", "请求参数有误"),
    LOGIN_FAIL("004001", "登陆失败，请重新登录"),
    AUTH_FAIL("003004", "鉴权失败，请重新登录"),
    FAIL("005000", "处理失败，服务器异常");

    private final String value;
    private final String message;

    ResponseCommonCode(String value, String message) {
        this.value = value;
        this.message = message;
    }

    public String getValue() {
        return this.value;
    }

    public String getMessage() {
        return this.message;
    }

}
