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
public class Banner implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String bannerImg;
	//
	private Integer index;
	//
	private String bannerUrl;
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
	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}
	/**
	 * 获取：
	 */
	public String getBannerImg() {
		return bannerImg;
	}
	/**
	 * 设置：
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}
	/**
	 * 获取：
	 */
	public Integer getIndex() {
		return index;
	}
	/**
	 * 设置：
	 */
	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}
	/**
	 * 获取：
	 */
	public String getBannerUrl() {
		return bannerUrl;
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
}
