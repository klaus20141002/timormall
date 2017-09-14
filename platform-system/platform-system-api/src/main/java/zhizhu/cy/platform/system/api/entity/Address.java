package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 餐饮-地址表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:48
 */
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
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
	//创建时间
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
