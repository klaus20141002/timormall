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
public class GoodsBasic implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long goodsId;
	//
	private Integer platformId;
	//商品名称
	private String goodsTitle;
	//商品展示图
	private String goodsImg;
	//商品详情页
	private String itemUrl;
	//原价
	private BigDecimal goodsPrice;
	//促销价
	private BigDecimal goodsPricePro;
	//快递费
	private BigDecimal goodsDeliverFee;
	//商品缩略图
	private String thumbnailImgs;
	//商品详情图
	private String detailImgs;
	//分类
	private String category;
	//销量
	private Integer volume;
	//
	private Date createTime;
	//
	private Date updateTime;
	//1正常 ， 0 已删除
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
	 * 设置：商品名称
	 */
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsTitle() {
		return goodsTitle;
	}
	/**
	 * 设置：商品展示图
	 */
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	/**
	 * 获取：商品展示图
	 */
	public String getGoodsImg() {
		return goodsImg;
	}
	/**
	 * 设置：商品详情页
	 */
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	/**
	 * 获取：商品详情页
	 */
	public String getItemUrl() {
		return itemUrl;
	}
	/**
	 * 设置：原价
	 */
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * 获取：原价
	 */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	/**
	 * 设置：促销价
	 */
	public void setGoodsPricePro(BigDecimal goodsPricePro) {
		this.goodsPricePro = goodsPricePro;
	}
	/**
	 * 获取：促销价
	 */
	public BigDecimal getGoodsPricePro() {
		return goodsPricePro;
	}
	/**
	 * 设置：快递费
	 */
	public void setGoodsDeliverFee(BigDecimal goodsDeliverFee) {
		this.goodsDeliverFee = goodsDeliverFee;
	}
	/**
	 * 获取：快递费
	 */
	public BigDecimal getGoodsDeliverFee() {
		return goodsDeliverFee;
	}
	/**
	 * 设置：商品缩略图
	 */
	public void setThumbnailImgs(String thumbnailImgs) {
		this.thumbnailImgs = thumbnailImgs;
	}
	/**
	 * 获取：商品缩略图
	 */
	public String getThumbnailImgs() {
		return thumbnailImgs;
	}
	/**
	 * 设置：商品详情图
	 */
	public void setDetailImgs(String detailImgs) {
		this.detailImgs = detailImgs;
	}
	/**
	 * 获取：商品详情图
	 */
	public String getDetailImgs() {
		return detailImgs;
	}
	/**
	 * 设置：分类
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * 获取：分类
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 设置：销量
	 */
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	/**
	 * 获取：销量
	 */
	public Integer getVolume() {
		return volume;
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
	 * 设置：1正常 ， 0 已删除
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：1正常 ， 0 已删除
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
}
