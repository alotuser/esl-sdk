package com.esl.open.sdk.request;

import java.util.List;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;
import com.esl.open.sdk.dto.PicTaskDto;

import cn.hutool.json.JSONUtil;

/**
 * <p>
 * Pic任务
 * </p>
 *
 * @author zdview
 * @since 2025-07-03
 */
public class SendPicTaskRequest extends EslOpenRequest {

	public SendPicTaskRequest(SystemParam systemParam,List<PicTaskDto> tasks) {
		super("/sendPicTask", RequestMethodTypeEnum.POST, RequestContentTypeEnum.BODY, systemParam);
		this.setRequestBody(JSONUtil.toJsonStr(tasks));
	}

}
