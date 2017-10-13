package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SkuModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SkuProps> skuProps ;
	private Map<String, String> ppathIdmap ;
	private boolean installmentEnable;
	public List<SkuProps> getSkuProps() {
		return skuProps;
	}
	public void setSkuProps(List<SkuProps> skuProps) {
		this.skuProps = skuProps;
	}
	public Map<String, String> getPpathIdmap() {
		return ppathIdmap;
	}
	public void setPpathIdmap(Map<String, String> ppathIdmap) {
		this.ppathIdmap = ppathIdmap;
	}
	public boolean isInstallmentEnable() {
		return installmentEnable;
	}
	public void setInstallmentEnable(boolean installmentEnable) {
		this.installmentEnable = installmentEnable;
	}

}
