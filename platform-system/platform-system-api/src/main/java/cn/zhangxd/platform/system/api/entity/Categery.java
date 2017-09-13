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
public class Categery implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Integer catName;
	//
	private String catImg;
	//
	private Integer catIndex;
	//
	private String catDesc;
	//
	private String catDescImg;
	//
	private String remark;
	//
	private Date createDate;
	//
	private Date updateDate;
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
	public void setCatName(Integer catName) {
		this.catName = catName;
	}
	/**
	 * 获取：
	 */
	public Integer getCatName() {
		return catName;
	}
	/**
	 * 设置：
	 */
	public void setCatImg(String catImg) {
		this.catImg = catImg;
	}
	/**
	 * 获取：
	 */
	public String getCatImg() {
		return catImg;
	}
	/**
	 * 设置：
	 */
	public void setCatIndex(Integer catIndex) {
		this.catIndex = catIndex;
	}
	/**
	 * 获取：
	 */
	public Integer getCatIndex() {
		return catIndex;
	}
	/**
	 * 设置：
	 */
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	/**
	 * 获取：
	 */
	public String getCatDesc() {
		return catDesc;
	}
	/**
	 * 设置：
	 */
	public void setCatDescImg(String catDescImg) {
		this.catDescImg = catDescImg;
	}
	/**
	 * 获取：
	 */
	public String getCatDescImg() {
		return catDescImg;
	}
	/**
	 * 设置：
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：
	 */
	public String getRemark() {
		return remark;
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
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateDate() {
		return updateDate;
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
