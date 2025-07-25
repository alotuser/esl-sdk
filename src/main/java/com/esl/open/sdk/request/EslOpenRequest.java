package com.esl.open.sdk.request;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;
import com.esl.open.sdk.exception.EslOpenException;
import com.esl.open.sdk.response.EslOpenResponse;
import com.esl.open.sdk.util.ConvertUtil;
import com.esl.open.sdk.util.PropertiesUtil;

import cn.hutool.core.map.TableMap;
import cn.hutool.core.net.url.UrlBuilder;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;

/**
 * *
 * <p>
 * EslOpenRequest类用于构建和发送请求到ESL开放平台。
 * </p>
 * 
 * @author zdview
 * @since 2025-07-03
 */
public class EslOpenRequest {
	private String uri;
	private RequestMethodTypeEnum requestMethodType;
	private RequestContentTypeEnum requestContentType;
	private SystemParam systemParam;

	protected TableMap<String, String> requestForm;
	protected String requestBody;

	private boolean isAsync;
	protected static Set<Class<?>> BASIC_PARAM_TYPE_SET = new HashSet<Class<?>>();

	protected static int timeout = 30000;

	public EslOpenRequest(String uri, RequestMethodTypeEnum requestMethodType, RequestContentTypeEnum requestContentType, SystemParam systemParam) {
		this.uri = uri;
		this.requestMethodType = requestMethodType;
		this.requestContentType = requestContentType;
		this.systemParam = systemParam;
	}

	public EslOpenRequest(String uri, RequestMethodTypeEnum requestMethodType, RequestContentTypeEnum requestContentType, SystemParam systemParam, boolean isAsync) {
		this.uri = uri;
		this.requestMethodType = requestMethodType;
		this.requestContentType = requestContentType;
		this.systemParam = systemParam;
		this.isAsync = isAsync;
	}
	/**
	 * 构造应用参数Map
	 * @return
	 * @throws EslOpenException
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, String> constructApplicationParamMap() throws EslOpenException {
		try {
			Map<String, String> paramMap = new TableMap<String, String>();
			Field[] declaredFields = this.getClass().getDeclaredFields();
			if (declaredFields != null && declaredFields.length != 0) {
				for (Field declaredField : declaredFields) {
					declaredField.setAccessible(true);
					Class typeClass = declaredField.getType();
					String paramName = declaredField.getName();
					String paramValue = null;
					if (BASIC_PARAM_TYPE_SET.contains(typeClass)) {
						paramValue = String.valueOf(declaredField.get(this));
						if (paramValue != null && !"".equals(paramValue) && !"null".equals(paramValue) && !"NULL".equals(paramValue)) {
							paramMap.put(paramName, paramValue);
						}
					} else {
						Map<String, String> objectMap = ConvertUtil.convertToMap(declaredField.get(this));
						paramMap.putAll(objectMap);
					}

					if (paramValue != null && !"".equals(paramValue) && !"null".equals(paramValue) && !"NULL".equals(paramValue)) {
						paramMap.put(paramName, paramValue);
					}
				}

				this.fillExtraInfo(paramMap);
				return paramMap;
			} else {
				return paramMap;
			}
		} catch (Exception e) {
			throw new EslOpenException(e);
		}
	}

	protected void fillExtraInfo(Map<String, String> paramMap) {
//	        String sdkVersion = PropertiesUtil.getSdkersion();
//	        paramMap.put("request_source", "sg_open_sdk-" + sdkVersion);
	}

	/**
	 * 执行请求
	 * 
	 * @return EslOpenResponse
	 * @throws EslOpenException
	 * @throws IOException
	 */
	public EslOpenResponse doRequest() throws EslOpenException, IOException {
		if (this.systemParam == null) {
			throw new EslOpenException("systemParam不能为null");
		} else {

			EslOpenResponse eslOpenResponse = new EslOpenResponse();
			Map<String, String> systemParamMap = ConvertUtil.convertSystemParamsToMap(this.systemParam);

			String url = UrlBuilder.of(this.systemParam.getAppUrl()).addPath(uri).build().toString();

			HttpRequest httpRequest = HttpUtil.createRequest(Method.valueOf(requestMethodType.getCode()), url).addHeaders(systemParamMap);
			HttpResponse res;
			switch (this.requestContentType) {
			case FORM:

				Map<String, String> applicationParamMap = this.constructApplicationParamMap();

				if (null != requestForm) {
					applicationParamMap.putAll(requestForm);
				}

				res = httpRequest.formStr(applicationParamMap).timeout(timeout).execute(isAsync);

				eslOpenResponse.setBaseString(res.getStatus() + "");
				eslOpenResponse.setRequestResult(res.body());
				break;
			case BODY:
				res = httpRequest.body(requestBody).timeout(timeout).execute(isAsync);
				eslOpenResponse.setBaseString(res.getStatus() + "");
				eslOpenResponse.setRequestResult(res.body());
				break;

			default:
				break;
			}

//			EslOpenResponse eslOpenResponse = new EslOpenResponse();
//			
//			
//			spliceToken(this.systemParam, applicationParamMap, systemParamMap);
//			String urlForGenSig = URLFactory.genUrlForGenSig(this.uri, systemParamMap, applicationParamMap);
//			String baseString = urlForGenSig.substring(0, urlForGenSig.length() - 16);
//			String sig = SignUtil.genSig(urlForGenSig);
//			eslOpenResponse.setBaseString(baseString);
//			eslOpenResponse.setRequestSig(sig);
//			String urlPrefix = URLFactory.genUrlPrefix(this.uri);
//			String resultString = HttpUtil.request(urlPrefix, genUrlForGetRequest(urlPrefix, systemParamMap, applicationParamMap), sig, systemParamMap, applicationParamMap, this.requestMethodType, PropertiesUtil.getRequestConfig());
//			EslOpenResponse.setRequestResult(resultString);
//			EslOpenResponse = this.checkResultCodeOfRetry(EslOpenResponse, this.uri, this.systemParam, applicationParamMap, (String) systemParamMap.get("access_token"));
//			
//			

			return eslOpenResponse;
		}
	}

//
//	    public EslOpenResponse doAsyncRequest() throws EslOpenException, IOException {
//	        if (this.systemParam == null) {
//	            throw new EslOpenException("systemParam不能为null");
//	        } else {
//	            EslOpenResponse EslOpenResponse = new EslOpenResponse();
//	            Map<String, String> systemParamMap = ConvertUtil.convertSystemParamsToMap(this.systemParam);
//	            Map<String, String> applicationParamMap = this.constructApplicationParamMap();
//	            spliceToken(this.systemParam, applicationParamMap, systemParamMap);
//	            String urlForGenSig = URLFactory.genUrlForGenSig(this.uri, systemParamMap, applicationParamMap);
//	            String baseString = urlForGenSig.substring(0, urlForGenSig.length() - 16);
//	            String sig = SignUtil.genSig(urlForGenSig);
//	            EslOpenResponse.setBaseString(baseString);
//	            EslOpenResponse.setRequestSig(sig);
//	            String urlPrefix = URLFactory.genUrlPrefix(this.uri);
//	            String resultString = HttpUtil.requestAsync(urlPrefix, genUrlForGetRequest(urlPrefix, systemParamMap, applicationParamMap), sig, systemParamMap, applicationParamMap, this.requestMethodType, PropertiesUtil.getRequestConfig(), this.isAsync);
//	            EslOpenResponse.setRequestResult(resultString);
//	            EslOpenResponse = this.checkResultCodeOfRetry(EslOpenResponse, this.uri, this.systemParam, applicationParamMap, (String)systemParamMap.get("access_token"));
//	            return EslOpenResponse;
//	        }
//	    }
//
//	    protected EslOpenResponse requestApi(Map<String, String> applicationParamMap, byte[] fileData, String fileName) throws IOException, EslOpenException {
//	        EslOpenResponse EslOpenResponse = new EslOpenResponse();
//	        Map<String, String> systemParamMap = ConvertUtil.convertSystemParamsToMap(this.systemParam);
//	        spliceToken(this.systemParam, applicationParamMap, systemParamMap);
//	        String urlForGenSig = URLFactory.genUrlForGenSig(this.uri, systemParamMap, applicationParamMap);
//	        String sig = SignUtil.genSig(urlForGenSig);
//	        EslOpenResponse.setRequestSig(sig);
//	        String urlPrefix = URLFactory.genUrlPrefix(this.uri);
//	        String resultString = HttpUtil.request(urlPrefix, genUrlForGetRequest(urlPrefix, systemParamMap, applicationParamMap), sig, systemParamMap, applicationParamMap, fileData, fileName, this.requestMethodType, PropertiesUtil.getRequestConfig());
//	        EslOpenResponse.setRequestResult(resultString);
//	        EslOpenResponse = this.checkResultCodeOfRetry(EslOpenResponse, this.uri, this.systemParam, applicationParamMap, (String)systemParamMap.get("access_token"));
//	        return EslOpenResponse;
//	    }
//
//	    protected static String genUrlForGetRequest(String urlPrefix, Map<String, String> systemParamsMap, Map<String, String> applicationParamsMap) throws EslOpenException {
//	        String uriParamStr = "app_id=" + (String)systemParamsMap.get("app_id") + "&timestamp=" + (String)systemParamsMap.get("timestamp");
//	        String access_token = (String)systemParamsMap.get("access_token");
//	        if (access_token != null) {
//	            uriParamStr = uriParamStr + "&" + "access_token" + "=" + access_token;
//	        }
//
//	        if (applicationParamsMap != null && !"null".equals(applicationParamsMap) && !"NULL".equals(applicationParamsMap)) {
//	            for(String key : applicationParamsMap.keySet()) {
//	                String val = (String)applicationParamsMap.get(key);
//	                if (val != null) {
//	                    try {
//	                        key = URLEncoder.encode(key, "UTF-8");
//	                        val = URLEncoder.encode(val, "UTF-8");
//	                        uriParamStr = uriParamStr + "&" + key + "=" + val;
//	                    } catch (UnsupportedEncodingException e) {
//	                        throw new EslOpenException(e);
//	                    }
//	                }
//	            }
//	        }
//
//	        String basedUrl = urlPrefix + "?" + uriParamStr;
//	        return basedUrl;
//	    }
//
//	    protected static String getAppPoiId(SystemParam systemParam, Map<String, String> applicationParamsMap) {
//	        String appPoiCode = (String)applicationParamsMap.get("app_poi_code");
//	        if (StrUtil.isBlank(appPoiCode)) {
//	            appPoiCode = systemParam.getAppPoiCode();
//	        }
//
//	        return appPoiCode;
//	    }
//
	protected static void spliceToken(SystemParam systemParam, Map<String, String> applicationParamsMap, Map<String, String> systemParamsMap) throws EslOpenException, IOException {
//		if (!OAuthConfig.IS_SIG) {
//			String inputAppPoiToken = systemParam.getAppPoiAccessToken();
//			if (StrUtil.isNotBlank(inputAppPoiToken)) {
//				systemParamsMap.put("access_token", inputAppPoiToken);
//			} else {
//				String appPoiCode = getAppPoiId(systemParam, applicationParamsMap);
//				if (!StrUtil.isBlank(appPoiCode)) {
//					String appId = systemParam.getAppId();
//					String appSecret = systemParam.getAppSecret();
//					if (!StrUtil.isBlank(appId) && !StrUtil.isBlank(appSecret)) {
//						TokenParam tokenParam = LoadMemoryToken.readTokenCache(appId, appPoiCode, appSecret);
//						Boolean need_reduce = tokenParam.getNeed_Reduce();
//						if (need_reduce == null || !need_reduce) {
//							String access_token = tokenParam.getAccess_token();
//							systemParamsMap.put("access_token", access_token == null ? "" : access_token);
//						}
//					} else {
//						throw new EslOpenException("系统参数中的appId和appSecret均不能为空");
//					}
//				}
//			}
//		}
	}

	protected EslOpenResponse checkResultCodeOfRetry(EslOpenResponse eslOpenResponse, String uri, SystemParam systemParam, Map<String, String> applicationParamMap, String accessToken) throws EslOpenException, IOException {
//	        String inputAppPoiToken = systemParam.getAppPoiAccessToken();
//	        if (!OAuthConfig.IS_SIG && !StrUtil.isNotBlank(inputAppPoiToken) && HttpUtil.getResponseErrorCode(eslOpenResponse.getRequestResult()) == OAuthResponseEnum.ACCESS_TOKEN_ERROR.getStatus()) {
//	            SimpleLogUtil.log("[OAuth托管]-token过期，重新获取或续期token，接口返回值：" + eslOpenResponse.getRequestResult(), new Object[0]);
//	            LoadMemoryToken.removeAccessTokenCache(systemParam.getAppId(), getAppPoiId(systemParam, applicationParamMap), accessToken);
//	            Map<String, String> systemParamMap = ConvertUtil.convertSystemParamsToMap(systemParam);
//	            spliceToken(systemParam, applicationParamMap, systemParamMap);
//	            String urlForGenSig = URLFactory.genUrlForGenSig(uri, systemParamMap, applicationParamMap);
//	            String sig = SignUtil.genSig(urlForGenSig);
//	            EslOpenResponse retryResponse = new EslOpenResponse();
//	            retryResponse.setRequestSig(sig);
//	            String urlPrefix = URLFactory.genUrlPrefix(this.uri);
//	            String resultString = HttpUtil.request(urlPrefix, genUrlForGetRequest(urlPrefix, systemParamMap, applicationParamMap), sig, systemParamMap, applicationParamMap, this.requestMethodType, PropertiesUtil.getRequestConfig());
//	            retryResponse.setRequestResult(resultString);
//	            return retryResponse;
//	        } else {
//	            return eslOpenResponse;
//	        }

		return eslOpenResponse;

	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public RequestMethodTypeEnum getRequestMethodType() {
		return requestMethodType;
	}

	public void setRequestMethodType(RequestMethodTypeEnum requestMethodType) {
		this.requestMethodType = requestMethodType;
	}

	public RequestContentTypeEnum getRequestContentType() {
		return requestContentType;
	}

	public void setRequestContentType(RequestContentTypeEnum requestContentType) {
		this.requestContentType = requestContentType;
	}

	public SystemParam getSystemParam() {
		return this.systemParam;
	}

	public void setSystemParam(SystemParam systemParam) {
		this.systemParam = systemParam;
	}

	public TableMap<String, String> getRequestForm() {
		return requestForm;
	}

	public void setRequestForm(TableMap<String, String> requestForm) {
		this.requestForm = requestForm;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public static int getTimeout() {
		return timeout;
	}

	public static void setTimeout(int timeout) {
		EslOpenRequest.timeout = timeout;
	}

	public boolean getIsAsync() {
		return this.isAsync;
	}

	public void setIsAsync(boolean isAsync) {
		this.isAsync = isAsync;
	}

	static {

		try {
			timeout = PropertiesUtil.getConnectTimeOut();
		} catch (IOException e) {
			timeout = 30000;
		}
		BASIC_PARAM_TYPE_SET.add(Boolean.TYPE);
		BASIC_PARAM_TYPE_SET.add(Boolean.class);
		BASIC_PARAM_TYPE_SET.add(Integer.TYPE);
		BASIC_PARAM_TYPE_SET.add(Integer.class);
		BASIC_PARAM_TYPE_SET.add(Long.TYPE);
		BASIC_PARAM_TYPE_SET.add(Long.class);
		BASIC_PARAM_TYPE_SET.add(Float.TYPE);
		BASIC_PARAM_TYPE_SET.add(Float.class);
		BASIC_PARAM_TYPE_SET.add(Double.TYPE);
		BASIC_PARAM_TYPE_SET.add(Double.class);
		BASIC_PARAM_TYPE_SET.add(String.class);
	}
}
