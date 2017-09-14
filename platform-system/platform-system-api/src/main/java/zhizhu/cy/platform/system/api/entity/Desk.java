package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 餐饮，桌子表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
public class Desk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//商户ID
	private Long deskMerchantId;
	//桌号
	private String deskNumber;
	//标准可用就餐人数
	private Integer deskAvailableNu;
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
	 * 设置：商户ID
	 */
	public void setDeskMerchantId(Long deskMerchantId) {
		this.deskMerchantId = deskMerchantId;
	}
	/**
	 * 获取：商户ID
	 */
	public Long getDeskMerchantId() {
		return deskMerchantId;
	}
	/**
	 * 设置：桌号
	 */
	public void setDeskNumber(String deskNumber) {
		this.deskNumber = deskNumber;
	}
	/**
	 * 获取：桌号
	 */
	public String getDeskNumber() {
		return deskNumber;
	}
	/**
	 * 设置：标准可用就餐人数
	 */
	public void setDeskAvailableNu(Integer deskAvailableNu) {
		this.deskAvailableNu = deskAvailableNu;
	}
	/**
	 * 获取：标准可用就餐人数
	 */
	public Integer getDeskAvailableNu() {
		return deskAvailableNu;
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
