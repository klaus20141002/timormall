/******************************************************************************
 * @File name   :      WebConfig.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月21日
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
 * 2017年9月21日 下午5:09:28        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.admin.web.common.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
public class WebConfig {
	@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("8280KB");
        factory.setMaxRequestSize("8280KB");
        factory.setLocation("/");
        return factory.createMultipartConfig();
    }
	
}
