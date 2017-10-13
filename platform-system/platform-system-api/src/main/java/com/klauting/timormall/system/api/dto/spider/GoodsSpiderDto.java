package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;
import java.util.List;

public class GoodsSpiderDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String api;
	private String v;
	private List<String> ret;
	private GoodsSpiderInfoDto data;
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public List<String> getRet() {
		return ret;
	}
	public void setRet(List<String> ret) {
		this.ret = ret;
	}
	public GoodsSpiderInfoDto getData() {
		return data;
	}
	public void setData(GoodsSpiderInfoDto data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "GoodsSpiderDto [api=" + api + ", v=" + v + ", ret=" + ret + ", data=" + data + "]";
	}

}
