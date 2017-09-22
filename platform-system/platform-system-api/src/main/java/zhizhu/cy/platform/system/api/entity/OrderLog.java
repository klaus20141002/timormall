package zhizhu.cy.platform.system.api.entity;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class OrderLog extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//订单ID
	private Long orderId;
	//1 : 取消 ， 2： 执行完成 ， 3 ：下单成功
	private Integer operationType;
	//描述
	private String logDesc;
	//用户ID
	private String userId;
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
	 * 设置：1 : 取消 ， 2： 执行完成 ， 3 ：下单成功
	 */
	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	/**
	 * 获取：1 : 取消 ， 2： 执行完成 ， 3 ：下单成功
	 */
	public Integer getOperationType() {
		return operationType;
	}
	/**
	 * 设置：描述
	 */
	public void setLogDesc(String logDesc) {
		this.logDesc = logDesc;
	}
	/**
	 * 获取：描述
	 */
	public String getLogDesc() {
		return logDesc;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID
	 */
	public String getUserId() {
		return userId;
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
