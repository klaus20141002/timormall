package zhizhu.cy.platform.system.api.entity;

import java.math.BigDecimal;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
public class FoodSku extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//
	private Long foodId;
	//
	private Long skuId;
	//属性组合
	private String propsRelation;
	//数量
	private Integer quantity;
	//销售价
	private BigDecimal price;
	//促销价
	private BigDecimal promotionPrice;
	//sku状态
	private Integer flagUse;
	//表备注
	private String remark;
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
	public void setSkuId(Long skuId) {
		this.skuId = skuId;
	}
	/**
	 * 获取：
	 */
	public Long getSkuId() {
		return skuId;
	}
	/**
	 * 设置：属性组合
	 */
	public void setPropsRelation(String propsRelation) {
		this.propsRelation = propsRelation;
	}
	/**
	 * 获取：属性组合
	 */
	public String getPropsRelation() {
		return propsRelation;
	}
	/**
	 * 设置：数量
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * 获取：数量
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * 设置：销售价
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：销售价
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：促销价
	 */
	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	/**
	 * 获取：促销价
	 */
	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}
	/**
	 * 设置：sku状态
	 */
	public void setFlagUse(Integer flagUse) {
		this.flagUse = flagUse;
	}
	/**
	 * 获取：sku状态
	 */
	public Integer getFlagUse() {
		return flagUse;
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
