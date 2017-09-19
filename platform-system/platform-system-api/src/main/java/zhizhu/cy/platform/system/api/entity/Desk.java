package zhizhu.cy.platform.system.api.entity;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 餐饮，桌子表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
public class Desk extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//商户ID
	private Long deskMerchantId;
	//桌号
	private String deskNumber;
	//标准可用就餐人数
	private Integer deskAvailableNu;
	//表备注
	private String remark;
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
