package com.esl.open.sdk.request;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;

/**
 * * <p>获取价签请求</p>
 */
public class GetTagRequest extends EslOpenRequest{

	public GetTagRequest(SystemParam systemParam) {
		super("/getTag", RequestMethodTypeEnum.POST, RequestContentTypeEnum.FORM, systemParam);
		
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
	 * 版本
	 */
	private String ver;
	 
	
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
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
}
