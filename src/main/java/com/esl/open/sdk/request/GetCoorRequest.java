package com.esl.open.sdk.request;

import com.esl.open.sdk.constants.RequestContentTypeEnum;
import com.esl.open.sdk.constants.RequestMethodTypeEnum;
import com.esl.open.sdk.domain.SystemParam;

/**
 * * <p>获取基站请求</p>
 */
public class GetCoorRequest extends EslOpenRequest{

	public GetCoorRequest(SystemParam systemParam) {
		super("/getCoor", RequestMethodTypeEnum.POST, RequestContentTypeEnum.FORM, systemParam);
		
	}
	/**
	 * 当前页
	 */
	private Long current;
	/**
	 * 每页显示条数
	 */
	private Long size;
	/**
	 * 价签id
	 */
	private String coorId;
	/**
	 * 版本
	 */
	private String ver;
	 
	/**
	 * barcode
	 */
	private String barcode;
	
	
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
	public String getCoorId() {
		return coorId;
	}
	public void setCoorId(String coorId) {
		this.coorId = coorId;
	}
	public String getVer() {
		return ver;
	}
	public void setVer(String ver) {
		this.ver = ver;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
