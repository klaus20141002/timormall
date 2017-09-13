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
public class FoodProperty implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//菜品ID
	private Long foodId;
	//属性ID
	private Long propertyId;
	//属性顺序
	private Integer rank;
	//别名
	private String alias;
	//创建时间
	private Date createDate;
	//更新时间
	private Date updateDate;
	//是否删除 ：1 已删， 0 未删
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
	 * 设置：菜品ID
	 */
	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}
	/**
	 * 获取：菜品ID
	 */
	public Long getFoodId() {
		return foodId;
	}
	/**
	 * 设置：属性ID
	 */
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	/**
	 * 获取：属性ID
	 */
	public Long getPropertyId() {
		return propertyId;
	}
	/**
	 * 设置：属性顺序
	 */
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	/**
	 * 获取：属性顺序
	 */
	public Integer getRank() {
		return rank;
	}
	/**
	 * 设置：别名
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 获取：别名
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateDate() {
		return updateDate;
	}
	/**
	 * 设置：是否删除 ：1 已删， 0 未删
	 */
	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}
	/**
	 * 获取：是否删除 ：1 已删， 0 未删
	 */
	public Integer getDelFlag() {
		return delFlag;
	}
}
