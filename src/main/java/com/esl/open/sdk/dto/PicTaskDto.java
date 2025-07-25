package com.esl.open.sdk.dto;

import java.util.List;

import com.esl.open.sdk.constants.SystemConstants;

public class PicTaskDto {
	/**
	 *  任务唯一id
	 */
	private String tid;

	/**
	 *  价签id
	 */
	private Integer tagId;

	/**
	 *  页数 1
	 */
	private Integer pageNo = SystemConstants.ONE;

	/**
	 *  图片地址
	 */
	private String imageSrc;

	/**
	 *  scale, Can be empty
	 */
	private List<ScaleDto> scale;

	/**
	 * 任务唯一id
	 */
	public String getTid() {
		return tid;
	}

	/**
	 * 任务唯一id
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

	/**
	 * scale
	 */
	public List<ScaleDto> getScale() {
		return scale;
	}

	/**
	 * scale
	 */
	public void setScale(List<ScaleDto> scale) {
		this.scale = scale;
	}
}
