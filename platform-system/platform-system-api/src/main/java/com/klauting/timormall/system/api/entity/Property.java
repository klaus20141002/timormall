package com.klauting.timormall.system.api.entity;

import com.klauting.timormall.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class Property extends DataEntity {
	private static final long serialVersionUID = 1L;
	//属性ID
	private Long propId;
	//属性名称
	private String propName;
	//表备注
	private String remark;

	/**
	 * 设置：属性ID
	 */
	public void setPropId(Long propId) {
		this.propId = propId;
	}
	/**
	 * 获取：属性ID
	 */
	public Long getPropId() {
		return propId;
	}
	/**
	 * 设置：属性名称
	 */
	public void setPropName(String propName) {
		this.propName = propName;
	}
	/**
	 * 获取：属性名称
	 */
	public String getPropName() {
		return propName;
	}
	/**
	 * 设置：表备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：表备注
	 */
	public String getRemark() {
		return remark;
	}
}
