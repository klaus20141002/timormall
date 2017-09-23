/******************************************************************************
 * @File name   :      AliPayStorageService.java
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
 * 2017年9月22日 上午11:29:46        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.mobile.client.util.payservice;

import java.util.Map;

/**
 *
 */
public class AliPayStorageService extends PayStorageService {
	
	

	/**
	 * @Date        :      2017年9月22日
	 */
	public AliPayStorageService(PayStorageConfig config) {
		this.config=config;
	}

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年9月22日
	 * @see com.klauting.timormall.mobile.client.util.payservice.PayStorageService#pay()
	**/
	@Override
	public Map<String, Object> pay() {
		// TODO Auto-generated method stub
		return null;
	}

}
