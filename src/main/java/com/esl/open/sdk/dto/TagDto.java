package com.esl.open.sdk.dto;

/**
 * <p>
 * 价签信息
 * </p>
 *
 * @author zdview
 * @since 2025-07-03
 */

public class TagDto {

	// 价签id
	private Long tagId;

	// 类型
	private String tagType;

	// 日期
	private String tagTime;

	// 电量
	private String tagPower;

	// 屏幕编号
	private String epdCode;

	// 信号量
	private String lqi;

	// 版本
	private String ver;

	// 页数
	private Integer pageNo;

	// 温度
	private String temperature;

	// nfc条形码
	private String nfcBarcode;

	// 更新时间
	private String updateTime;

	// 基站更新id
	private String updateId;

	/**
	 * 价签id
	 */
	public Long getTagId() {
		return tagId;
	}

	/**
	 * 价签id
	 */
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	/**
	 * 类型
	 */
	public String getTagType() {
		return tagType;
	}

	/**
	 * 类型
	 */
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

	/**
	 * 日期
	 */
	public String getTagTime() {
		return tagTime;
	}

	/**
	 * 日期
	 */
	public void setTagTime(String tagTime) {
		this.tagTime = tagTime;
	}

	/**
	 * 电量
	 */
	public String getTagPower() {
		return tagPower;
	}

	/**
	 * 电量
	 */
	public void setTagPower(String tagPower) {
		this.tagPower = tagPower;
	}

	/**
	 * epd
	 */
	public String getEpdCode() {
		return epdCode;
	}

	/**
	 * epd
	 */
	public void setEpdCode(String epdCode) {
		this.epdCode = epdCode;
	}

	/**
	 * lqi
	 */
	public String getLqi() {
		return lqi;
	}

	/**
	 * lqi
	 */
	public void setLqi(String lqi) {
		this.lqi = lqi;
	}

	/**
	 * 版本
	 */
	public String getVer() {
		return ver;
	}

	/**
	 * 版本
	 */
	public void setVer(String ver) {
		this.ver = ver;
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
	 * 温度
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * 温度
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	/**
	 * nfc条形码
	 */
	public String getNfcBarcode() {
		return nfcBarcode;
	}

	/**
	 * nfc条形码
	 */
	public void setNfcBarcode(String nfcBarcode) {
		this.nfcBarcode = nfcBarcode;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	@Override
	public String toString() {
		return "Tag{" + "tagId=" + tagId + ", tagType=" + tagType + ", tagTime=" + tagTime + ", tagPower=" + tagPower + ", epdCode=" + epdCode + ", lqi=" + lqi + ", ver=" + ver + ", pageNo=" + pageNo + ", temperature=" + temperature + ", nfcBarcode=" + nfcBarcode + "}";
	}
}
