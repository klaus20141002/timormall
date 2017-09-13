package cn.zhangxd.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
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
	//评论时间
	private Date createDate;
	//最后修改时间
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
	 * 设置：评论时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：评论时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：最后修改时间
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：最后修改时间
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
