package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
public class PropValue implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//商品ID
	private Long foodsId;
	//属性ID
	private Long propId;
	//值ID
	private Long valueId;
	//sku头图
	private String colorImg;
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
	 * 设置：商品ID
	 */
	public void setFoodsId(Long foodsId) {
		this.foodsId = foodsId;
	}
	/**
	 * 获取：商品ID
	 */
	public Long getFoodsId() {
		return foodsId;
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
	 * 设置：sku头图
	 */
	public void setColorImg(String colorImg) {
		this.colorImg = colorImg;
	}
	/**
	 * 获取：sku头图
	 */
	public String getColorImg() {
		return colorImg;
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
