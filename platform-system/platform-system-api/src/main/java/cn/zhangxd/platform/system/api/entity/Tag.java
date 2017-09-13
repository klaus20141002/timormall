package cn.zhangxd.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String tagName;
	//
	private Integer tagIndex;
	//
	private Date createDate;
	//
	private Date updateTime;
	//
	private Integer delFlag;

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
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	/**
	 * 获取：
	 */
	public String getTagName() {
		return tagName;
	}
	/**
	 * 设置：
	 */
	public void setTagIndex(Integer tagIndex) {
		this.tagIndex = tagIndex;
	}
	/**
	 * 获取：
	 */
	public Integer getTagIndex() {
		return tagIndex;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreateDate() {
		return createDate;
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
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
}
