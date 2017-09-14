package zhizhu.cy.platform.system.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
public class Food implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//商品名称
	private String foodName;
	//商品描述
	private String foodDesc;
	//类别
	private Long foodCatId;
	//销售价
	private BigDecimal foodPrice;
	//促销价
	private BigDecimal foodProPrice;
	//商品图
	private String foodImages;
	//销量
	private Integer foodVolume;
	//用户展示今日状态 ， 1 :在售 ， 2 ：已售完
	private Integer foodStatus;
	//用于展示长期状态 ， 1 : 正常 ， 2:不可用【缺货】
	private Integer foodState;
	//商户ID
	private Long foodMerchantId;
	//是否包含sku
	private Integer foodIsContainSku;
	//库存
	private Integer foodSaleLimitNum;
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
	 * 设置：商品名称
	 */
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getFoodName() {
		return foodName;
	}
	/**
	 * 设置：商品描述
	 */
	public void setFoodDesc(String foodDesc) {
		this.foodDesc = foodDesc;
	}
	/**
	 * 获取：商品描述
	 */
	public String getFoodDesc() {
		return foodDesc;
	}
	/**
	 * 设置：类别
	 */
	public void setFoodCatId(Long foodCatId) {
		this.foodCatId = foodCatId;
	}
	/**
	 * 获取：类别
	 */
	public Long getFoodCatId() {
		return foodCatId;
	}
	/**
	 * 设置：销售价
	 */
	public void setFoodPrice(BigDecimal foodPrice) {
		this.foodPrice = foodPrice;
	}
	/**
	 * 获取：销售价
	 */
	public BigDecimal getFoodPrice() {
		return foodPrice;
	}
	/**
	 * 设置：促销价
	 */
	public void setFoodProPrice(BigDecimal foodProPrice) {
		this.foodProPrice = foodProPrice;
	}
	/**
	 * 获取：促销价
	 */
	public BigDecimal getFoodProPrice() {
		return foodProPrice;
	}
	/**
	 * 设置：商品图
	 */
	public void setFoodImages(String foodImages) {
		this.foodImages = foodImages;
	}
	/**
	 * 获取：商品图
	 */
	public String getFoodImages() {
		return foodImages;
	}
	/**
	 * 设置：销量
	 */
	public void setFoodVolume(Integer foodVolume) {
		this.foodVolume = foodVolume;
	}
	/**
	 * 获取：销量
	 */
	public Integer getFoodVolume() {
		return foodVolume;
	}
	/**
	 * 设置：用户展示今日状态 ， 1 :在售 ， 2 ：已售完
	 */
	public void setFoodStatus(Integer foodStatus) {
		this.foodStatus = foodStatus;
	}
	/**
	 * 获取：用户展示今日状态 ， 1 :在售 ， 2 ：已售完
	 */
	public Integer getFoodStatus() {
		return foodStatus;
	}
	/**
	 * 设置：用于展示长期状态 ， 1 : 正常 ， 2:不可用【缺货】
	 */
	public void setFoodState(Integer foodState) {
		this.foodState = foodState;
	}
	/**
	 * 获取：用于展示长期状态 ， 1 : 正常 ， 2:不可用【缺货】
	 */
	public Integer getFoodState() {
		return foodState;
	}
	/**
	 * 设置：商户ID
	 */
	public void setFoodMerchantId(Long foodMerchantId) {
		this.foodMerchantId = foodMerchantId;
	}
	/**
	 * 获取：商户ID
	 */
	public Long getFoodMerchantId() {
		return foodMerchantId;
	}
	/**
	 * 设置：是否包含sku
	 */
	public void setFoodIsContainSku(Integer foodIsContainSku) {
		this.foodIsContainSku = foodIsContainSku;
	}
	/**
	 * 获取：是否包含sku
	 */
	public Integer getFoodIsContainSku() {
		return foodIsContainSku;
	}
	/**
	 * 设置：库存
	 */
	public void setFoodSaleLimitNum(Integer foodSaleLimitNum) {
		this.foodSaleLimitNum = foodSaleLimitNum;
	}
	/**
	 * 获取：库存
	 */
	public Integer getFoodSaleLimitNum() {
		return foodSaleLimitNum;
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
