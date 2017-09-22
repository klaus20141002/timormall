package zhizhu.cy.platform.system.api.entity;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class OrderComment extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//用户ID，微信open ID
	private Long userId;
	//订单ID
	private Long orderId;
	//星级，代表用户的满意程度，逐级递减
	private Integer star;
	//评论内容
	private String comments;
	//表备注
	private String remark;

	/**
	 * 设置：用户ID，微信open ID
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户ID，微信open ID
	 */
	public Long getUserId() {
		return userId;
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
	 * 设置：星级，代表用户的满意程度，逐级递减
	 */
	public void setStar(Integer star) {
		this.star = star;
	}
	/**
	 * 获取：星级，代表用户的满意程度，逐级递减
	 */
	public Integer getStar() {
		return star;
	}
	/**
	 * 设置：评论内容
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * 获取：评论内容
	 */
	public String getComments() {
		return comments;
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
