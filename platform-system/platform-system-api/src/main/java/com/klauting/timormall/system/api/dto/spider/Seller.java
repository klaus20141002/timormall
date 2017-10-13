package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;
import java.util.List;

public class Seller implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userNumId ;
	private String type;
	private String nick;
	private String creditLevel;
	private String goodRatePercentage;
	private String shopTitle;
	private String shopId;
	private String weitaoId;
	private String fansCount;
	private String fansCountText;
	private List<EvaluateInfo> evaluateInfo;
	private String picUrl;
	private String starts;
	private String shopPromtionType;
	private List<ActionUnits> actionUnits;
	public String getUserNumId() {
		return userNumId;
	}
	public void setUserNumId(String userNumId) {
		this.userNumId = userNumId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getCreditLevel() {
		return creditLevel;
	}
	public void setCreditLevel(String creditLevel) {
		this.creditLevel = creditLevel;
	}
	public String getGoodRatePercentage() {
		return goodRatePercentage;
	}
	public void setGoodRatePercentage(String goodRatePercentage) {
		this.goodRatePercentage = goodRatePercentage;
	}
	public String getShopTitle() {
		return shopTitle;
	}
	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getWeitaoId() {
		return weitaoId;
	}
	public void setWeitaoId(String weitaoId) {
		this.weitaoId = weitaoId;
	}
	public String getFansCount() {
		return fansCount;
	}
	public void setFansCount(String fansCount) {
		this.fansCount = fansCount;
	}
	public String getFansCountText() {
		return fansCountText;
	}
	public void setFansCountText(String fansCountText) {
		this.fansCountText = fansCountText;
	}
	public List<EvaluateInfo> getEvaluateInfo() {
		return evaluateInfo;
	}
	public void setEvaluateInfo(List<EvaluateInfo> evaluateInfo) {
		this.evaluateInfo = evaluateInfo;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getStarts() {
		return starts;
	}
	public void setStarts(String starts) {
		this.starts = starts;
	}
	public String getShopPromtionType() {
		return shopPromtionType;
	}
	public void setShopPromtionType(String shopPromtionType) {
		this.shopPromtionType = shopPromtionType;
	}
	public List<ActionUnits> getActionUnits() {
		return actionUnits;
	}
	public void setActionUnits(List<ActionUnits> actionUnits) {
		this.actionUnits = actionUnits;
	}
	
	
}
