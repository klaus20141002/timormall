package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;
import java.util.List;

public class ItemInfoModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long itemId ;
	private String title;
	private List<String> picsPath;
	private String favcount;
	private String  stuffStatus;
	private String itemUrl;
	private boolean sku;
	private String location;
	private String saleLine;
	private Long categoryId;
	private String itemTypeName;
	private String itemTypeLogo;
	private String itemIcon;
	private boolean isMakeup;
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getPicsPath() {
		return picsPath;
	}
	public void setPicsPath(List<String> picsPath) {
		this.picsPath = picsPath;
	}
	public String getFavcount() {
		return favcount;
	}
	public void setFavcount(String favcount) {
		this.favcount = favcount;
	}
	public String getStuffStatus() {
		return stuffStatus;
	}
	public void setStuffStatus(String stuffStatus) {
		this.stuffStatus = stuffStatus;
	}
	public String getItemUrl() {
		return itemUrl;
	}
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}
	public boolean isSku() {
		return sku;
	}
	public void setSku(boolean sku) {
		this.sku = sku;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSaleLine() {
		return saleLine;
	}
	public void setSaleLine(String saleLine) {
		this.saleLine = saleLine;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemTypeName() {
		return itemTypeName;
	}
	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}
	public String getItemTypeLogo() {
		return itemTypeLogo;
	}
	public void setItemTypeLogo(String itemTypeLogo) {
		this.itemTypeLogo = itemTypeLogo;
	}
	public String getItemIcon() {
		return itemIcon;
	}
	public void setItemIcon(String itemIcon) {
		this.itemIcon = itemIcon;
	}
	public boolean isMakeup() {
		return isMakeup;
	}
	public void setMakeup(boolean isMakeup) {
		this.isMakeup = isMakeup;
	}
	@Override
	public String toString() {
		return "ItemInfoModel [itemId=" + itemId + ", title=" + title + ", picsPath=" + picsPath + ", favcount="
				+ favcount + ", stuffStatus=" + stuffStatus + ", itemUrl=" + itemUrl + ", sku=" + sku + ", location="
				+ location + ", saleLine=" + saleLine + ", categoryId=" + categoryId + ", itemTypeName=" + itemTypeName
				+ ", itemTypeLogo=" + itemTypeLogo + ", itemIcon=" + itemIcon + ", isMakeup=" + isMakeup + "]";
	}
	
	

}
