package zhizhu.cy.platform.system.api.entity;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
public class FoodProperty extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//菜品ID
	private Long foodId;
	//属性ID
	private Long propertyId;
	//属性顺序
	private Integer rank;
	//别名
	private String alias;
	//表备注
	private String remark;

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
}
