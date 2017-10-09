/******************************************************************************
 * @File name   :      GoodsDto.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年10月9日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年10月9日 下午7:30:50        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.klauting.timormall.system.api.constant.GlobalConstant;

/**
 *@author niklaus mikaelson
 */
public class GoodsBasicDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	//商品缩略图
	private String thumbnailImgs;
	//分类
	private String category;
	//销量
	private Integer volume;
	//
	private Date createTime;
	//
	private Date updateTime;
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getPlatformId() {
		return platformId;
	}
	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getItemUrl() {
		return itemUrl;
	}
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	// keep 2 decimals
	public BigDecimal getGoodsPrice() {
		return goodsPrice!=null?goodsPrice.setScale(2,BigDecimal.ROUND_HALF_UP):new BigDecimal("0.00");
	}
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	// keep 2 decimals
	public BigDecimal getGoodsPricePro() {
		return goodsPricePro!=null?goodsPricePro.setScale(2,BigDecimal.ROUND_HALF_UP):new BigDecimal("0.00");
	}
	public void setGoodsPricePro(BigDecimal goodsPricePro) {
		this.goodsPricePro = goodsPricePro;
	}
	public String getThumbnailImgs() {
		return thumbnailImgs;
	}
	public void setThumbnailImgs(String thumbnailImgs) {
		this.thumbnailImgs = thumbnailImgs;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	@JsonFormat(pattern=GlobalConstant.DATE_FORMAT_FULL,timezone = "GMT+8")  
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@JsonFormat(pattern=GlobalConstant.DATE_FORMAT_FULL,timezone = "GMT+8")  
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
