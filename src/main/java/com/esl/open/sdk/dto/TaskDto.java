package com.esl.open.sdk.dto;

/**
 * <p>
 * 任务列表
 * </p>
 *
 * @author zdview
 * @since 2025-07-03
 */
public class TaskDto {

	// 任务id
	private String tid;

	// UUID
	private String uid;

	// 价签id
	private Integer tagId;

	// 页数
	private Integer pageNo;

	// [{\"y1\":37,\"x1\":0,\"y2\":72,\"x2\":120}]
	private String scale;

	// 图片地址
	private String imageSrc;

	// 开始时间
	private String startTime;

	// 开始时间
	private String endTime;

	// LED:亮灯次数
	private Integer count;

	// LED:颜色
	private Integer color;

	// LED:频率
	private Integer freq;

	// LED:亮度
	private Integer light;

	// 任务状态 success wait doing fail
	private String taskStatus;

	// 任务删除, 0:未删除 1：已删除
	private String taskDel;

	// 任务发送, 0:未发 1：已发
	private String taskSend;

	// 创建时间
	private String createTime;

	// 创建人
	private String createUser;

	/**
	 * UUID
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * UUID
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 任务id
	 */
	public String getTid() {
		return tid;
	}

	/**
	 * 任务id
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

	/**
	 * 价签id
	 */
	public Integer getTagId() {
		return tagId;
	}

	/**
	 * 价签id
	 */
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	/**
	 * 页数
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * 页数
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 图片地址
	 */
	public String getImageSrc() {
		return imageSrc;
	}

	/**
	 * 图片地址
	 */
	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	public Integer getFreq() {
		return freq;
	}

	public void setFreq(Integer freq) {
		this.freq = freq;
	}

	public Integer getLight() {
		return light;
	}

	public void setLight(Integer light) {
		this.light = light;
	}

	/**
	 * 任务状态
	 */
	public String getTaskStatus() {
		return taskStatus;
	}

	/**
	 * 任务状态
	 */
	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	/**
	 * 任务删除
	 */
	public String getTaskDel() {
		return taskDel;
	}

	/**
	 * 任务删除
	 */
	public void setTaskDel(String taskDel) {
		this.taskDel = taskDel;
	}

	public String getTaskSend() {
		return taskSend;
	}

	public void setTaskSend(String taskSend) {
		this.taskSend = taskSend;
	}

	/**
	 * 创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * 创建人
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * 创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
	}

}
