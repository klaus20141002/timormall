package com.klauting.timormall.system.api.dto.spider;

import java.io.Serializable;

public class EvaluateInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String name;
	private String score;
	private String highGap;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getHighGap() {
		return highGap;
	}
	public void setHighGap(String highGap) {
		this.highGap = highGap;
	}

}
