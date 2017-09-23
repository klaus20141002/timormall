package com.klauting.timormall.system.api.entity;

import com.klauting.timormall.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class PropValue extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//商品ID
	private Long foodsId;
	//属性ID
	private Long propId;
	//值ID
	private Long valueId;
	//sku头图
	private String colorImg;
	//表备注
	private String remark;

	/**
	 * 设置：商品ID
	 */
	public void setFoodsId(Long foodsId) {
		this.foodsId = foodsId;
	}
	/**
	 * 获取：商品ID
	 */
	public Long getFoodsId() {
		return foodsId;
	}
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
	 * 设置：sku头图
	 */
	public void setColorImg(String colorImg) {
		this.colorImg = colorImg;
	}
	/**
	 * 获取：sku头图
	 */
	public String getColorImg() {
		return colorImg;
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
