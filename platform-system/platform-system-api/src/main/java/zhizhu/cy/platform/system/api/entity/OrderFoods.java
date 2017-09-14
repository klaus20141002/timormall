package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class OrderFoods implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
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
	//创建时间
	private Date createTime;
	//
	private Date updateTime;
	//是否删除 ：0 已删， 1 未删
	private Integer dataStatus;
	//表备注
	private String remark;

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
