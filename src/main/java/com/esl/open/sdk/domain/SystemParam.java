package com.esl.open.sdk.domain;

/**
 * *
 * <p>
 * 系统级参数
 * </p>
 */
public class SystemParam {

	public static final String APP_ID = "appId";
	public static final String APP_SECRET = "appSecret";
	public static final String APP_POI_ACCESS_TOKEN = "appPoiAccessToken";
	public static final String APPID = "app_id";
	public static final String TIMESTAMP = "timestamp";

	private String appUrl;
	private String appId;
	private String appSecret;
	private String appPoiAccessToken;
	private String appPoiCode;

	public SystemParam(String appUrl, String appId, String appSecret) {
		this.appUrl = appUrl;
		this.appId = appId;
		this.appSecret = appSecret;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getAppPoiAccessToken() {
		return this.appPoiAccessToken;
	}

	public SystemParam setAppPoiAccessToken(String appPoiAccessToken) {
		this.appPoiAccessToken = appPoiAccessToken;
		return this;
	}

	public String getAppPoiCode() {
		return this.appPoiCode;
	}

	public SystemParam setAppPoiCode(String appPoiCode) {
		this.appPoiCode = appPoiCode;
		return this;
	}

	public String getAppId() {
		return this.appId;
	}

	public SystemParam setAppId(String appId) {
		this.appId = appId;
		return this;
	}

	public String getAppSecret() {
		return this.appSecret;
	}

	public SystemParam setAppSecret(String appSecret) {
		this.appSecret = appSecret;
		return this;
	}
}
