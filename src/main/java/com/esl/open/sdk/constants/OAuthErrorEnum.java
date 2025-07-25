package com.esl.open.sdk.constants;

public enum OAuthErrorEnum {
    SERVER_ERROR(500, "OAuth系统错误"),
    ELSE_ERROR(400, "其他请求异常");

    private int code;
    private String msg;

    private OAuthErrorEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String toString() {
        return "code:" + this.code + ", msg:" + this.msg;
    }
}