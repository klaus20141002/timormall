package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public class FoodSku implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
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
	private Integer isUse;
	//创建时间
	private Date createDate;
	//最后更新时间
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
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：sku状态
	 */
	public Integer getIsUse() {
		return isUse;
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
	 * 设置：最后更新时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：最后更新时间
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
