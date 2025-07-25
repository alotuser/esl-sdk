package com.esl.open.sdk.dto;

/**
 * * *
 * <p>
 * 分页任务DTO
 * </p>
 * 
 * @author zdview
 * @since 2025-07-03
 */
public class PageTaskDto extends PicTaskDto {

	/**
	 *  开始时间 yyyy-MM-dd HH:mm:ss
	 */
	private String startTime;

	/**
	 *  结束时间 yyyy-MM-dd HH:mm:ss
	 */
	private String endTime;
	/**
	 *  开始时间 yyyy-MM-dd HH:mm:ss
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 *  开始时间 yyyy-MM-dd HH:mm:ss
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 *  结束时间 yyyy-MM-dd HH:mm:ss
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 *  结束时间 yyyy-MM-dd HH:mm:ss
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
