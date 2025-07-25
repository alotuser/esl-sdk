package com.esl.open.sdk.request;

import java.util.List;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;
import com.esl.open.sdk.dto.DelTaskDto;

import cn.hutool.core.map.TableMap;

/**
 * <p>
 * Del任务
 * </p>
 *
 * @author zdview
 * @since 2025-07-03
 */
public class SendDelTaskRequest extends EslOpenRequest{

	
	public SendDelTaskRequest(SystemParam systemParam,DelTaskDto task) {
		super("/sendDelTask", RequestMethodTypeEnum.POST,RequestContentTypeEnum.FORM, systemParam);
		TableMap<String, String> tm=new TableMap<>();
		List<String> tids = task.getTids();
		for (String tid : tids) {
			tm.put("tids", tid);
		}
		this.setRequestForm(tm);
	}
}
