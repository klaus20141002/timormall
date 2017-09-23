package com.klauting.timormall.system.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public class GoodsExt implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Integer goodsId;
	//
	private Integer platformId;
	//卖家旺旺
	private String sellerWanwan;
	//卖家id
	private Integer sellerId;
	//店铺名称
	private String shopTitle;
	//佣金比率
	private BigDecimal tkRate;
	//佣金
	private BigDecimal tkMoney;
	//
	private Date createTime;
	//
	private Date updateTiem;
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
	 * 设置：卖家旺旺
	 */
	public void setSellerWanwan(String sellerWanwan) {
		this.sellerWanwan = sellerWanwan;
	}
	/**
	 * 获取：卖家旺旺
	 */
	public String getSellerWanwan() {
		return sellerWanwan;
	}
	/**
	 * 设置：卖家id
	 */
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	/**
	 * 获取：卖家id
	 */
	public Integer getSellerId() {
		return sellerId;
	}
	/**
	 * 设置：店铺名称
	 */
	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getShopTitle() {
		return shopTitle;
	}
	/**
	 * 设置：佣金比率
	 */
	public void setTkRate(BigDecimal tkRate) {
		this.tkRate = tkRate;
	}
	/**
	 * 获取：佣金比率
	 */
	public BigDecimal getTkRate() {
		return tkRate;
	}
	/**
	 * 设置：佣金
	 */
	public void setTkMoney(BigDecimal tkMoney) {
		this.tkMoney = tkMoney;
	}
	/**
	 * 获取：佣金
	 */
	public BigDecimal getTkMoney() {
		return tkMoney;
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
	public void setUpdateTiem(Date updateTiem) {
		this.updateTiem = updateTiem;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTiem() {
		return updateTiem;
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
}
