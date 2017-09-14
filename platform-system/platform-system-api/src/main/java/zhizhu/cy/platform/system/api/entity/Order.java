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
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
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
