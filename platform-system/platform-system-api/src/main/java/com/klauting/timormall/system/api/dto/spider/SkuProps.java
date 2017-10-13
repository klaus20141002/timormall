package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;
import java.util.List;

public class SkuProps implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String propId;
	private String propName;
	private List<ValueDto> values;
	public String getPropId() {
		return propId;
	}
	public void setPropId(String propId) {
		this.propId = propId;
	}
	public String getPropName() {
		return propName;
	}
	public void setPropName(String propName) {
		this.propName = propName;
	}
	public List<ValueDto> getValues() {
		return values;
	}
	public void setValues(List<ValueDto> values) {
		this.values = values;
	}
	
}
