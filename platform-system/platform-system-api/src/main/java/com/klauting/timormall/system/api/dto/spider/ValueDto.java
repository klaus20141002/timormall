package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;

public class ValueDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String valueId;
	private String name;
	public String getValueId() {
		return valueId;
	}
	public void setValueId(String valueId) {
		this.valueId = valueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
