/******************************************************************************
 * @File name   :      CommonConstant.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月16日
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
 * 2017年7月16日 下午8:02:25        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.mobile.client.constant;

/**
 *
 */
public class CommonConstant {
	private CommonConstant() {
		
	}
	//淘宝商品文件目录
	public static final String GOODS_TAOBAO_FILEPATH ="/data/deploy/backend/goods/taobao/" ;
	public static final String GOODS_AD_DEFAULT ="快乐的Hope" ;
	
	
    
    // RFC 822 Date Format
	public static final String RFC822_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss z";
	public static final String RFC822_DATE_FORMAT_SHORT = "yyyy-MM-dd";
	
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    // ISO 8601 format
	public static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    // Alternate ISO 8601 format without fractional seconds
	public static final String ALTERNATIVE_ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

}
