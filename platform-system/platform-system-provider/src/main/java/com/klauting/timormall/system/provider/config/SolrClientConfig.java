/******************************************************************************
 * @File name   :      solrClientConfig.java
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
 * 2017年10月9日 下午10:05:12        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.provider.config;

import java.io.IOException;

import javax.annotation.PreDestroy;

import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 *
 */
//@Configuration
//@EnableConfigurationProperties(SolrConfig.class)
public class SolrClientConfig {
	@Autowired
	private SolrConfig solrConfig;

	private CloudSolrServer solrServer;
	
	private static final Logger logger = LoggerFactory.getLogger( SolrClientConfig.class );

//	@PreDestroy
	public void close() {
	    if (this.solrServer != null) {
	        try {
	            this.solrServer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
//	@Bean 
	public CloudSolrServer SolrServer(){
		logger.info("CloudSolrServer init ....................................");
	    if (StringUtils.hasText(this.solrConfig.getZkHost())) {
	        //solrClient = new CloudSolrClient(this.solrConfig.getZkHost());
	        solrServer = new CloudSolrServer(this.solrConfig.getZkHost());
	        solrServer.setDefaultCollection(this.solrConfig.getDefaultCollection());
	    }
	    return this.solrServer;
	}
}
