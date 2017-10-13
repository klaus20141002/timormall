package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;

public class DescInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String briefDescUrl;
	private String fullDescUrl;
	private String showFullDetailDesc;
	private String pcDescUrl;
	private String h5DescUrl;
	private String h5DescUrl2;
	private String moduleDescUrl2;
	public String getBriefDescUrl() {
		return briefDescUrl;
	}
	public void setBriefDescUrl(String briefDescUrl) {
		this.briefDescUrl = briefDescUrl;
	}
	public String getFullDescUrl() {
		return fullDescUrl;
	}
	public void setFullDescUrl(String fullDescUrl) {
		this.fullDescUrl = fullDescUrl;
	}
	public String getShowFullDetailDesc() {
		return showFullDetailDesc;
	}
	public void setShowFullDetailDesc(String showFullDetailDesc) {
		this.showFullDetailDesc = showFullDetailDesc;
	}
	public String getPcDescUrl() {
		return pcDescUrl;
	}
	public void setPcDescUrl(String pcDescUrl) {
		this.pcDescUrl = pcDescUrl;
	}
	public String getH5DescUrl() {
		return h5DescUrl;
	}
	public void setH5DescUrl(String h5DescUrl) {
		this.h5DescUrl = h5DescUrl;
	}
	public String getH5DescUrl2() {
		return h5DescUrl2;
	}
	public void setH5DescUrl2(String h5DescUrl2) {
		this.h5DescUrl2 = h5DescUrl2;
	}
	public String getModuleDescUrl2() {
		return moduleDescUrl2;
	}
	public void setModuleDescUrl2(String moduleDescUrl2) {
		this.moduleDescUrl2 = moduleDescUrl2;
	}
	
	
}
