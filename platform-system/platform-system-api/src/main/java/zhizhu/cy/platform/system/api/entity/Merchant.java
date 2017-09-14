package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public class Merchant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//名称
	private String merchantName;
	//
	private String merchantNotice;
	//商家描述
	private String merchantDesc;
	//电话
	private String merchantMobile;
	//
	private String merchantLogo;
	//
	private String merchantRunTime;
	//地址id
	private Long merchantAddressId;
	//创建时间
	private Date createDate;
	//最后更新时间
	private Date updateDate;
	//是否删除 ：1 已删， 0 未删
	private Integer delFlag;
	//状态 ， 1 ：正常 ， 2 ， 不可用 
	private Integer merchantStatus;

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
	 * 设置：名称
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	/**
	 * 获取：名称
	 */
	public String getMerchantName() {
		return merchantName;
	}
	/**
	 * 设置：
	 */
	public void setMerchantNotice(String merchantNotice) {
		this.merchantNotice = merchantNotice;
	}
	/**
	 * 获取：
	 */
	public String getMerchantNotice() {
		return merchantNotice;
	}
	/**
	 * 设置：商家描述
	 */
	public void setMerchantDesc(String merchantDesc) {
		this.merchantDesc = merchantDesc;
	}
	/**
	 * 获取：商家描述
	 */
	public String getMerchantDesc() {
		return merchantDesc;
	}
	/**
	 * 设置：电话
	 */
	public void setMerchantMobile(String merchantMobile) {
		this.merchantMobile = merchantMobile;
	}
	/**
	 * 获取：电话
	 */
	public String getMerchantMobile() {
		return merchantMobile;
	}
	/**
	 * 设置：
	 */
	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo;
	}
	/**
	 * 获取：
	 */
	public String getMerchantLogo() {
		return merchantLogo;
	}
	/**
	 * 设置：
	 */
	public void setMerchantRunTime(String merchantRunTime) {
		this.merchantRunTime = merchantRunTime;
	}
	/**
	 * 获取：
	 */
	public String getMerchantRunTime() {
		return merchantRunTime;
	}
	/**
	 * 设置：地址id
	 */
	public void setMerchantAddressId(Long merchantAddressId) {
		this.merchantAddressId = merchantAddressId;
	}
	/**
	 * 获取：地址id
	 */
	public Long getMerchantAddressId() {
		return merchantAddressId;
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
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：最后更新时间
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
	/**
	 * 设置：状态 ， 1 ：正常 ， 2 ， 不可用 
	 */
	public void setMerchantStatus(Integer merchantStatus) {
		this.merchantStatus = merchantStatus;
	}
	/**
	 * 获取：状态 ， 1 ：正常 ， 2 ， 不可用 
	 */
	public Integer getMerchantStatus() {
		return merchantStatus;
	}
}
