package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class Categery implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
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
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//表备注
	private String remark;
	//是否删除 ：0 已删， 1 未删
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
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
	/**
	 * 设置：是否删除 ：0 已删， 1 未删
	 */
	public void setDataStatus(Integer dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 获取：是否删除 ：0 已删， 1 未删
	 */
	public Integer getDataStatus() {
		return dataStatus;
	}
}
