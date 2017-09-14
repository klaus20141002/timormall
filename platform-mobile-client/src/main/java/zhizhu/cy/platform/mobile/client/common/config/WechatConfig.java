/******************************************************************************
 * @File name   :      WechatConfig.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月8日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年9月8日 上午10:51:45        niklaus     1.0            Initial Version
 *****************************************************************************/
package zhizhu.cy.platform.mobile.client.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *
 */
@ConfigurationProperties(prefix="wechat")
public class WechatConfig {
	private String appid;
    private Integer appsecret;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public Integer getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(Integer appsecret) {
		this.appsecret = appsecret;
	}
    
}
