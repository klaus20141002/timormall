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
public class Order extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//桌子
	private Long deskId;
	//订单ID，yyyy_mm_dd+商家ID+6位序列号
	private String orderNo;
	//类型，Here or TOGO
	private Integer orderType;
	//订单状态
	private Integer orderStatus;
	//订单备注
	private String orderRemark;
	//订单总价
	private BigDecimal orderTotalPrice;
	//账户余额
	private BigDecimal orderVirtualPrice;
	//优惠券
	private BigDecimal orderCouponPrice;
	//地址id
	private Long orderAddressId;
	//地址快照
	private String orderAddress;
	//用户ID
	private Long orderUserId;
	//商户ID
	private Long orderMerchantId;
	//表备注
	private String remark;
	/**
	 * 设置：桌子
	 */
	public void setDeskId(Long deskId) {
		this.deskId = deskId;
	}
	/**
	 * 获取：桌子
	 */
	public Long getDeskId() {
		return deskId;
	}
	/**
	 * 设置：订单ID，yyyy_mm_dd+商家ID+6位序列号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单ID，yyyy_mm_dd+商家ID+6位序列号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：类型，Here or TOGO
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：类型，Here or TOGO
	 */
	public Integer getOrderType() {
		return orderType;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：订单备注
	 */
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	/**
	 * 获取：订单备注
	 */
	public String getOrderRemark() {
		return orderRemark;
	}
	/**
	 * 设置：订单总价
	 */
	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	/**
	 * 获取：订单总价
	 */
	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}
	/**
	 * 设置：账户余额
	 */
	public void setOrderVirtualPrice(BigDecimal orderVirtualPrice) {
		this.orderVirtualPrice = orderVirtualPrice;
	}
	/**
	 * 获取：账户余额
	 */
	public BigDecimal getOrderVirtualPrice() {
		return orderVirtualPrice;
	}
	/**
	 * 设置：优惠券
	 */
	public void setOrderCouponPrice(BigDecimal orderCouponPrice) {
		this.orderCouponPrice = orderCouponPrice;
	}
	/**
	 * 获取：优惠券
	 */
	public BigDecimal getOrderCouponPrice() {
		return orderCouponPrice;
	}
	/**
	 * 设置：地址id
	 */
	public void setOrderAddressId(Long orderAddressId) {
		this.orderAddressId = orderAddressId;
	}
	/**
	 * 获取：地址id
	 */
	public Long getOrderAddressId() {
		return orderAddressId;
	}
	/**
	 * 设置：地址快照
	 */
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	/**
	 * 获取：地址快照
	 */
	public String getOrderAddress() {
		return orderAddress;
	}
	/**
	 * 设置：用户ID
	 */
	public void setOrderUserId(Long orderUserId) {
		this.orderUserId = orderUserId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getOrderUserId() {
		return orderUserId;
	}
	/**
	 * 设置：商户ID
	 */
	public void setOrderMerchantId(Long orderMerchantId) {
		this.orderMerchantId = orderMerchantId;
	}
	/**
	 * 获取：商户ID
	 */
	public Long getOrderMerchantId() {
		return orderMerchantId;
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
