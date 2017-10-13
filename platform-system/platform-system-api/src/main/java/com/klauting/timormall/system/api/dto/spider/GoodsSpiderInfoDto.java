package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;
import java.util.List;

public class GoodsSpiderInfoDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<ApiStack> apiStack;
	private ItemInfoModel itemInfoModel;
	private SkuModel skuModel;
	private Seller seller; 
	private List<PropsDto> props;
	private DescInfo descInfo;
	
	public List<ApiStack> getApiStack() {
		return apiStack;
	}
	public void setApiStack(List<ApiStack> apiStack) {
		this.apiStack = apiStack;
	}
	public ItemInfoModel getItemInfoModel() {
		return itemInfoModel;
	}
	public void setItemInfoModel(ItemInfoModel itemInfoModel) {
		this.itemInfoModel = itemInfoModel;
	}
	public SkuModel getSkuModel() {
		return skuModel;
	}
	public void setSkuModel(SkuModel skuModel) {
		this.skuModel = skuModel;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public List<PropsDto> getProps() {
		return props;
	}
	public void setProps(List<PropsDto> props) {
		this.props = props;
	}
	public DescInfo getDescInfo() {
		return descInfo;
	}
	public void setDescInfo(DescInfo descInfo) {
		this.descInfo = descInfo;
	}
	@Override
	public String toString() {
		return "GoodsSpiderInfoDto [apiStack=" + apiStack + ", itemInfoModel=" + itemInfoModel + ", skuModel="
				+ skuModel + ", seller=" + seller + ", props=" + props + ", descInfo=" + descInfo + "]";
	}
	
	
	
}
