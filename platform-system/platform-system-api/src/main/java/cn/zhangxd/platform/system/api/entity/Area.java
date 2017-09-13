package cn.zhangxd.platform.system.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;



/**
 * 餐饮-地址-区域选择表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//父级地址
	private Long parentId;
	//名称
	private String name;
	//名称
	private String shortName;
	//纬度
	private BigDecimal longtitude;
	//经度
	private BigDecimal latitude;
	//级别 ， 1 省， 2 ， 市， 3 ， 区/县
	private Integer level;
	//排序
	private Integer sort;
	//是否可用
	private Integer status;

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
	 * 设置：父级地址
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：父级地址
	 */
	public Long getParentId() {
		return parentId;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：名称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * 获取：名称
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * 设置：纬度
	 */
	public void setLongtitude(BigDecimal longtitude) {
		this.longtitude = longtitude;
	}
	/**
	 * 获取：纬度
	 */
	public BigDecimal getLongtitude() {
		return longtitude;
	}
	/**
	 * 设置：经度
	 */
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：经度
	 */
	public BigDecimal getLatitude() {
		return latitude;
	}
	/**
	 * 设置：级别 ， 1 省， 2 ， 市， 3 ， 区/县
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：级别 ， 1 省， 2 ， 市， 3 ， 区/县
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：是否可用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：是否可用
	 */
	public Integer getStatus() {
		return status;
	}
}
