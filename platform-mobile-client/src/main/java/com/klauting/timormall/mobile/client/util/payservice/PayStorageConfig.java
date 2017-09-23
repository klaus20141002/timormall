/******************************************************************************
 * @File name   :      PayStorageConfig.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月22日
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
 * 2017年9月22日 上午11:25:53        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.mobile.client.util.payservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component("payStorageConfig")
public class PayStorageConfig {
	
	
	//1 ali pay, 2 wechat pay
    @Value("${oss.type}")
    private String type;
    
    
    
    
    private String alimerchantId;
    private String aliSecret;
    private String payNotifyUrl;
    private String refundNotifyUrl;
    private String webReturnUrl;
    private String wapReturnUrl;
    
    
    
    

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    
    
    
    

}
