package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class OrderComment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//用户ID，微信open ID
	private Long userId;
	//订单ID
	private Long orderId;
	//星级，代表用户的满意程度，逐级递减
	private Integer star;
	//评论内容
	private String comments;
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
