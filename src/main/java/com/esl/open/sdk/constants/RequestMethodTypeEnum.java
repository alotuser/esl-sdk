package com.esl.open.sdk.constants;

public enum RequestMethodTypeEnum {
	POST("POST", "POST"),
    GET("GET", "GET");

    private String code;
    private String desc;

    private RequestMethodTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
