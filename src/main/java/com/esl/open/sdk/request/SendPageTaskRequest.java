package com.esl.open.sdk.request;

import java.util.List;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;
import com.esl.open.sdk.dto.PageTaskDto;

import cn.hutool.json.JSONUtil;

/**
 * <p>
 * page任务
 * </p>
 *
 * @author zdview
 * @since 2025-07-03
 */
public class SendPageTaskRequest extends EslOpenRequest {

	public SendPageTaskRequest(SystemParam systemParam,List<PageTaskDto> tasks) {
		super("/sendPageTask", RequestMethodTypeEnum.POST, RequestContentTypeEnum.BODY, systemParam);
		this.setRequestBody(JSONUtil.toJsonStr(tasks));
	}

	

}
