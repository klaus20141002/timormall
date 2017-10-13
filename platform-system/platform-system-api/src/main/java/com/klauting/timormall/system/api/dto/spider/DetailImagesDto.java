package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;
import java.util.List;

public class DetailImagesDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String api;
	private List<String> ret;
	private String v;
	
	private DetailImagesDescDto data;

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}
	
	public List<String> getRet() {
		return ret;
	}

	public void setRet(List<String> ret) {
		this.ret = ret;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public DetailImagesDescDto getData() {
		return data;
	}

	public void setData(DetailImagesDescDto data) {
		this.data = data;
	}
	

}
