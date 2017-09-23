/******************************************************************************
 * @File name   :      PayStorageService.java
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
 * 2017年9月22日 上午11:25:23        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.mobile.client.util.payservice;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public abstract class PayStorageService {
	
	public PayStorageConfig config;
	
	
	/**
	 * @Date        :      2017年9月22日
	 * @return
	 */
	public abstract Map<String,Object> pay() ;

}
