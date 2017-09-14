package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public class FoodTag implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private Long foodId;
	//
	private Long tagId;
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
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	/**
	 * 获取：
	 */
	public Long getFoodId() {
		return foodId;
	}
	/**
	 * 设置：
	 */
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
	/**
	 * 获取：
	 */
	public Long getTagId() {
		return tagId;
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
