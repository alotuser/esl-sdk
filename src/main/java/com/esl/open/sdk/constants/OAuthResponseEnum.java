package com.esl.open.sdk.constants;

public enum OAuthResponseEnum {

	SUCCESS(0, "成功"),
    ACCESS_TOKEN_ERROR(767, "ACCESS TOKEN已经过期"),
    REFRESH_TOKEN_ERROR(769, "REFRESH TOKEN已经过期");

    private int status;
    private String desc;

    private OAuthResponseEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return this.status;
    }

    public String getDesc() {
        return this.desc;
    }
    
}
