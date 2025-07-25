package com.esl.open.sdk.request;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;

/**
 * * <p>获取任务请求</p>
 */
public class GetTaskRequest extends EslOpenRequest{

	public GetTaskRequest(SystemParam systemParam) {
		super("/getTask", RequestMethodTypeEnum.POST, RequestContentTypeEnum.FORM, systemParam);
		
	}
	/**
	 * 当前页
	 */
	private Long current;
	/**
	 * 每页显示条数"
	 */
	private Long size;
	/**
	 * 价签id
	 */
	private String tagId;
	/**
	 * 任务状态
	 */
	private String taskStatus;
	/**
	 * 任务删除;0:未删除 1：已删除
	 */
	private String taskDel;
	/**
	 * 任务发送;0:未发 1：已发
	 */
	private String taskSend;
	/**
	 * 任务id，唯一
	 */
	private String tid;
	
	public Long getCurrent() {
		return current;
	}
	public void setCurrent(Long current) {
		this.current = current;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}
	public String getTaskDel() {
		return taskDel;
	}
	public void setTaskDel(String taskDel) {
		this.taskDel = taskDel;
	}
	public String getTaskSend() {
		return taskSend;
	}
	public void setTaskSend(String taskSend) {
		this.taskSend = taskSend;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}

	
	
}
