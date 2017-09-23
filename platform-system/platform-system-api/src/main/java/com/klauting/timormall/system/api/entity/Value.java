package com.klauting.timormall.system.api.entity;

import com.klauting.timormall.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class Value extends DataEntity {
	private static final long serialVersionUID = 1L;
	//属性ID
	private Long propertyId;
	//值ID
	private Long valueId;
	//值名称
	private String valueName;
	//表备注
	private String remark;

	/**
	 * 设置：属性ID
	 */
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	/**
	 * 获取：属性ID
	 */
	public Long getPropertyId() {
		return propertyId;
	}
	/**
	 * 设置：值ID
	 */
	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}
	/**
	 * 获取：值ID
	 */
	public Long getValueId() {
		return valueId;
	}
	/**
	 * 设置：值名称
	 */
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	/**
	 * 获取：值名称
	 */
	public String getValueName() {
		return valueName;
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
