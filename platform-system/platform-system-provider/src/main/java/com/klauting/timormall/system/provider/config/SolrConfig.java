/******************************************************************************
 * @File name   :      SolrConfig.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年10月9日
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
 * 2017年10月9日 下午10:01:36        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.provider.config;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author niklaus mikaelson
 */
//@ConfigurationProperties(prefix="spring.solr")
public class SolrConfig {
	private String host;
	private String zkHost;
	private String defaultCollection;


	public String getDefaultCollection() {
	    return defaultCollection;
	}
	public void setDefaultCollection(String defaultCollection) {
	    this.defaultCollection = defaultCollection;
	}
	public String getHost() {
	    return host;
	}
	public void setHost(String host) {
	    this.host = host;
	}
	public String getZkHost() {
	    return zkHost;
	}
	public void setZkHost(String zkHost) {
	    this.zkHost = zkHost;
	}
}
