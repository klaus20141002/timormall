package zhizhu.cy.platform.system.api.entity;

import java.math.BigDecimal;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class OrderFoods extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//订单ID
	private Long orderId;
	//商品SKU
	private Long foodsSkuId;
	//商品ID
	private Long foodsId;
	//数量
	private Integer count;
	//
	private BigDecimal price;
	//表备注
	private String remark;
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Long getOrderId() {
		return orderId;
	}
	/**
	 * 设置：商品SKU
	 */
	public void setFoodsSkuId(Long foodsSkuId) {
		this.foodsSkuId = foodsSkuId;
	}
	/**
	 * 获取：商品SKU
	 */
	public Long getFoodsSkuId() {
		return foodsSkuId;
	}
	/**
	 * 设置：商品ID
	 */
	public void setFoodsId(Long foodsId) {
		this.foodsId = foodsId;
	}
	/**
	 * 获取：商品ID
	 */
	public Long getFoodsId() {
		return foodsId;
	}
	/**
	 * 设置：数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 * 获取：数量
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * 设置：
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getPrice() {
		return price;
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
