package com.klauting.timormall.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 广告位表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public class Ad implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//广告位名称
	private String adName;
	//描述
	private String adDesc;
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
	 * 设置：描述
	 */
	public void setAdDesc(String adDesc) {
		this.adDesc = adDesc;
	}
	/**
	 * 获取：描述
	 */
	public String getAdDesc() {
		return adDesc;
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
