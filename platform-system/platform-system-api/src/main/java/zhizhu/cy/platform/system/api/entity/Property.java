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
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//属性ID
	private Long propId;
	//属性名称
	private Long propName;
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
	public void setPropId(Long propId) {
		this.propId = propId;
	}
	/**
	 * 获取：属性ID
	 */
	public Long getPropId() {
		return propId;
	}
	/**
	 * 设置：属性名称
	 */
	public void setPropName(Long propName) {
		this.propName = propName;
	}
	/**
	 * 获取：属性名称
	 */
	public Long getPropName() {
		return propName;
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
