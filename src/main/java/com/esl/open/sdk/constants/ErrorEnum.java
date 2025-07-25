package com.esl.open.sdk.constants;

public enum ErrorEnum {
	SYS_ERR(700, "系统错误"), LACK_OF_PARAM(701, "缺少参数，数据不完整");

	private int code;
	private String msg;

	private ErrorEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return this.code;
	}

	public String getMsg() {
		return this.msg;
	}

	public static ErrorEnum findByErrorCode(int errorCode) {
		switch (errorCode) {
		case 700:
			return SYS_ERR;
		case 701:
			return LACK_OF_PARAM;
		default:
			return null;
		}
	}

	public String toString() {
		return "code:" + this.code + ", msg:" + this.msg;
	}
}
