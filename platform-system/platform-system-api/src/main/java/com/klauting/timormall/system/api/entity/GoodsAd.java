package com.klauting.timormall.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public class GoodsAd implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String adName;
	//
	private Integer goodsId;
	//
	private Integer goodsPlatform;
	//
	private Date createTime;
	//
	private Date updateTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：
	 */
	public void setAdName(String adName) {
		this.adName = adName;
	}
	/**
	 * 获取：
	 */
	public String getAdName() {
		return adName;
	}
	/**
	 * 设置：
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：
	 */
	public void setGoodsPlatform(Integer goodsPlatform) {
		this.goodsPlatform = goodsPlatform;
	}
	/**
	 * 获取：
	 */
	public Integer getGoodsPlatform() {
		return goodsPlatform;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
}
