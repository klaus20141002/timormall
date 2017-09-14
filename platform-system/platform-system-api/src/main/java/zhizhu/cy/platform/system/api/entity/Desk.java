package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 餐饮，桌子表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public class Desk implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//商户ID
	private Long deskMerchantId;
	//桌号
	private String deskNumber;
	//创建时间
	private Date createDate;
	//最后更新时间
	private Date updateTime;
	//标准可用就餐人数
	private Integer deskAvailableNu;
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
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：最后更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
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
