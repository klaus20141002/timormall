package com.klauting.timormall.system.api.entity;

import com.klauting.timormall.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class Categery extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long merchantId;
	//名称
	private Integer catName;
	//分类图片
	private String catImg;
	//分类排序
	private Integer catIndex;
	//分类描述
	private String catDesc;
	//分类描述图片
	private String catDescImg;
	//备注
	private String catRemark;
	//表备注
	private String remark;

	/**
	 * 设置：
	 */
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * 获取：
	 */
	public Long getMerchantId() {
		return merchantId;
	}
	/**
	 * 设置：名称
	 */
	public void setCatName(Integer catName) {
		this.catName = catName;
	}
	/**
	 * 获取：名称
	 */
	public Integer getCatName() {
		return catName;
	}
	/**
	 * 设置：分类图片
	 */
	public void setCatImg(String catImg) {
		this.catImg = catImg;
	}
	/**
	 * 获取：分类图片
	 */
	public String getCatImg() {
		return catImg;
	}
	/**
	 * 设置：分类排序
	 */
	public void setCatIndex(Integer catIndex) {
		this.catIndex = catIndex;
	}
	/**
	 * 获取：分类排序
	 */
	public Integer getCatIndex() {
		return catIndex;
	}
	/**
	 * 设置：分类描述
	 */
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	/**
	 * 获取：分类描述
	 */
	public String getCatDesc() {
		return catDesc;
	}
	/**
	 * 设置：分类描述图片
	 */
	public void setCatDescImg(String catDescImg) {
		this.catDescImg = catDescImg;
	}
	/**
	 * 获取：分类描述图片
	 */
	public String getCatDescImg() {
		return catDescImg;
	}
	/**
	 * 设置：备注
	 */
	public void setCatRemark(String catRemark) {
		this.catRemark = catRemark;
	}
	/**
	 * 获取：备注
	 */
	public String getCatRemark() {
		return catRemark;
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
