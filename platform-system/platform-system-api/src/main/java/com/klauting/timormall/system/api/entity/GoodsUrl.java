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
public class GoodsUrl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long goodsId;
	//
	private Integer platformId;
	//广告位名称
	private String adName;
	//分销地址
	private String clickUrl;
	//淘口令
	private String clickTaokouling;
	//优惠券面额
	private String couponInfo;
	//优惠券地址
	private String couponUrl;
	//优惠券淘口令
	private String couponTaokouling;
	//商品优惠券推广链接
	private String couponClickUrl;
	//优惠券总量
	private Integer couponTotalCount;
	//优惠券剩余量
	private Integer couponRemainCount;
	//优惠券开始时间
	private Date couponStartTime;
	//优惠券结束时间
	private Date couponEndTime;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private Integer dataStatus;

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
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：
	 */
	public Long getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：
	 */
	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}
	/**
	 * 获取：
	 */
	public Integer getPlatformId() {
		return platformId;
	}
	/**
	 * 设置：广告位名称
	 */
	public void setAdName(String adName) {
		this.adName = adName;
	}
	/**
	 * 获取：广告位名称
	 */
	public String getAdName() {
		return adName;
	}
	/**
	 * 设置：分销地址
	 */
	public void setClickUrl(String clickUrl) {
		this.clickUrl = clickUrl;
	}
	/**
	 * 获取：分销地址
	 */
	public String getClickUrl() {
		return clickUrl;
	}
	/**
	 * 设置：优惠券面额
	 */
	public void setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
	}
	/**
	 * 获取：优惠券面额
	 */
	public String getCouponInfo() {
		return couponInfo;
	}
	/**
	 * 设置：优惠券地址
	 */
	public void setCouponUrl(String couponUrl) {
		this.couponUrl = couponUrl;
	}
	/**
	 * 获取：优惠券地址
	 */
	public String getCouponUrl() {
		return couponUrl;
	}
	/**
	 * 设置：商品优惠券推广链接
	 */
	public void setCouponClickUrl(String couponClickUrl) {
		this.couponClickUrl = couponClickUrl;
	}
	/**
	 * 获取：商品优惠券推广链接
	 */
	public String getCouponClickUrl() {
		return couponClickUrl;
	}
	/**
	 * 设置：优惠券总量
	 */
	public void setCouponTotalCount(Integer couponTotalCount) {
		this.couponTotalCount = couponTotalCount;
	}
	/**
	 * 获取：优惠券总量
	 */
	public Integer getCouponTotalCount() {
		return couponTotalCount;
	}
	/**
	 * 设置：优惠券剩余量
	 */
	public void setCouponRemainCount(Integer couponRemainCount) {
		this.couponRemainCount = couponRemainCount;
	}
	/**
	 * 获取：优惠券剩余量
	 */
	public Integer getCouponRemainCount() {
		return couponRemainCount;
	}
	/**
	 * 设置：优惠券开始时间
	 */
	public void setCouponStartTime(Date couponStartTime) {
		this.couponStartTime = couponStartTime;
	}
	/**
	 * 获取：优惠券开始时间
	 */
	public Date getCouponStartTime() {
		return couponStartTime;
	}
	/**
	 * 设置：优惠券结束时间
	 */
	public void setCouponEndTime(Date couponEndTime) {
		this.couponEndTime = couponEndTime;
	}
	/**
	 * 获取：优惠券结束时间
	 */
	public Date getCouponEndTime() {
		return couponEndTime;
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
	/**
	 * 设置：
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
	public String getClickTaokouling() {
		return clickTaokouling;
	}
	public void setClickTaokouling(String clickTaokouling) {
		this.clickTaokouling = clickTaokouling;
	}
	public String getCouponTaokouling() {
		return couponTaokouling;
	}
	public void setCouponTaokouling(String couponTaokouling) {
		this.couponTaokouling = couponTaokouling;
	}
	
	
}
