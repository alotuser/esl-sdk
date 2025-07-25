package com.esl.open.sdk.request;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;

/**
 * * <p>获取价签请求</p>
 */
public class GetEslRequest extends EslOpenRequest{
	public GetEslRequest(SystemParam systemParam) {
		super("/", RequestMethodTypeEnum.GET, RequestContentTypeEnum.FORM, systemParam);
		
	}
}
