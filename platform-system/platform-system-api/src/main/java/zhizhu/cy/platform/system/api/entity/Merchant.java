package zhizhu.cy.platform.system.api.entity;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class Merchant extends DataEntity {
	private static final long serialVersionUID = 1L;
	
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
	//状态 ， 1 ：正常 ， 2 ， 不可用
	private Integer merchantStatus;
	//表备注
	private String remark;

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
