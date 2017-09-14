package zhizhu.cy.platform.system.api.entity;

import zhizhu.cy.platform.common.api.DataEntity;



/**
 * 餐饮-地址表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
public class Address extends DataEntity {
	private static final long serialVersionUID = 1L;
	
	//用户ID
	private String userId;
	//省ID
	private Long provinceId;
	//市ID
	private Long cityId;
	//区ID
	private Long districtId;
	//邮编
	private String zipcode;
	//联系人电话
	private String mobile;
	//联系人名称
	private String contactName;
	//表备注
	private String remark;

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
	 * 设置：省ID
	 */
	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：省ID
	 */
	public Long getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：市ID
	 */
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：市ID
	 */
	public Long getCityId() {
		return cityId;
	}
	/**
	 * 设置：区ID
	 */
	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}
	/**
	 * 获取：区ID
	 */
	public Long getDistrictId() {
		return districtId;
	}
	/**
	 * 设置：邮编
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * 设置：联系人电话
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：联系人电话
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：联系人名称
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人名称
	 */
	public String getContactName() {
		return contactName;
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
