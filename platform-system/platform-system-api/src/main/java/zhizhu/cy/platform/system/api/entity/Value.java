package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public class Value implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//属性ID
	private Long propertyId;
	//值ID
	private Long valueId;
	//值名称
	private String valueName;
	//创建时间
	private Date createDate;
	//最后更新时间
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
	 * 设置：属性ID
	 */
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	/**
	 * 获取：属性ID
	 */
	public Long getPropertyId() {
		return propertyId;
	}
	/**
	 * 设置：值ID
	 */
	public void setValueId(Long valueId) {
		this.valueId = valueId;
	}
	/**
	 * 获取：值ID
	 */
	public Long getValueId() {
		return valueId;
	}
	/**
	 * 设置：值名称
	 */
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	/**
	 * 获取：值名称
	 */
	public String getValueName() {
		return valueName;
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
}
