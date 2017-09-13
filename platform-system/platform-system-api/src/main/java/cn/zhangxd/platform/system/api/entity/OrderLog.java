package cn.zhangxd.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public class OrderLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//订单ID
	private Long orderId;
	//1 : 取消 ， 2： 执行完成 ， 3 ：下单成功
	private String operationType;
	//用户ID
	private Long userId;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//是否删除 ：1 已删， 0 未删
	private Integer delFlag;
	//描述
	private String desc;

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
	 * 设置：1 : 取消 ， 2： 执行完成 ， 3 ：下单成功
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	/**
	 * 获取：1 : 取消 ， 2： 执行完成 ， 3 ：下单成功
	 */
	public String getOperationType() {
		return operationType;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public Long getUserId() {
		return userId;
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
	/**
	 * 设置：描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：描述
	 */
	public String getDesc() {
		return desc;
	}
}
