package com.esl.open.sdk.domain;

import java.io.Serializable;

public class TokenParam implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private String accessToken;
	private String refreshToken;
	private transient Boolean needReduce;

	public TokenParam(String accessToken, String refreshToken) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.needReduce = false;
	}

	public TokenParam(String accessToken, String refreshToken, Boolean needReduce) {
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.needReduce = needReduce;
	}

	public String getaccessToken() {
		return this.accessToken;
	}

	public String getrefreshToken() {
		return this.refreshToken;
	}

	public Boolean getneedReduce() {
		return this.needReduce;
	}

}
