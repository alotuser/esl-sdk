package com.esl.open.sdk.dto;

import com.esl.open.sdk.constants.SystemConstants;

/**
 * *
 * <p>
 * LED任务数据传输对象
 * </p>
 *
 * @author zdview
 * @since 2025-07-03
 */
public class LedTaskDto {

	/**
	 *  开始时间
	 */
	private String startTime;

	/**
	 *  亮灯次数 (次数 1~65535)
	 */
	private Integer count;

	/**
	 *  颜色 (分类：（范围1~7） 1红色 2绿色 3蓝色 4红色 5青色 6紫色 7白色)
	 */
	private Integer color;

	/**
	 *  频率 (100~5000)
	 */
	private Integer freq;

	/**
	 *  亮度 (亮度：10~50的范围)
	 */
	private Integer light;

	/**
	 *  pageNo
	 */
	private Integer pageNo = SystemConstants.ONE;

	/**
	 *  价签id
	 */
	private Long tagId;

	/**
	 *  任务唯一id
	 */
	private String tid;
	/**
	 *  开始时间
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
	 *  亮灯次数 (次数 1~65535)
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 *  亮灯次数 (次数 1~65535)
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 *  颜色 (分类：（范围1~7） 1红色 2绿色 3蓝色 4红色 5青色 6紫色 7白色)
	 */
	public Integer getColor() {
		return color;
	}
	/**
	 *  颜色 (分类：（范围1~7） 1红色 2绿色 3蓝色 4红色 5青色 6紫色 7白色)
	 */
	public void setColor(Integer color) {
		this.color = color;
	}
	/**
	 *  频率 (100~5000)
	 */
	public Integer getFreq() {
		return freq;
	}
	/**
	 *  频率 (100~5000)
	 */
	public void setFreq(Integer freq) {
		this.freq = freq;
	}
	/**
	 *  亮度 (亮度：10~50的范围)
	 */
	public Integer getLight() {
		return light;
	}
	/**
	 *  亮度 (亮度：10~50的范围)
	 */
	public void setLight(Integer light) {
		this.light = light;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	/**
	 *  价签id
	 */
	public Long getTagId() {
		return tagId;
	}
	/**
	 *  价签id
	 */
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	/**
	 *  任务唯一id
	 */
	public String getTid() {
		return tid;
	}
	/**
	 *  任务唯一id
	 */
	public void setTid(String tid) {
		this.tid = tid;
	}

}
