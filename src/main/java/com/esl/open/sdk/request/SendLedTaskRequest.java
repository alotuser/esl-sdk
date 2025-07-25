package com.esl.open.sdk.request;

import java.util.List;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;
import com.esl.open.sdk.dto.LedTaskDto;

import cn.hutool.json.JSONUtil;

/**
 * <p>
 * LED任务
 * </p>
 *
 * @author zdview
 * @since 2025-07-03
 */
public class SendLedTaskRequest extends EslOpenRequest{

	
	public SendLedTaskRequest(SystemParam systemParam,List<LedTaskDto> tasks) {
		
		super("/sendLedTask", RequestMethodTypeEnum.POST,RequestContentTypeEnum.BODY, systemParam);
		
		this.setRequestBody(JSONUtil.toJsonStr(tasks));
		
	}

}
