/******************************************************************************
 * @File name   :      PayFactory.java
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
 * 2017年9月22日 上午11:23:27        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.mobile.client.util.payservice;

import com.klauting.timormall.mobile.client.constant.Constant;
import com.klauting.timormall.mobile.client.util.SpringContextUtils;

/**
 * pay factory
 */
public class PayFactory {
	
	private static PayStorageConfig config;

    static {
    	PayFactory.config = (PayStorageConfig) SpringContextUtils.getBean("payStorageConfig");
        System.out.println("static invoked "+config.getType());
    }

    public static PayStorageService build(){
        //获取支付配置信息
        if(Integer.valueOf(config.getType()) == Constant.PayService.ALIPAY.getValue()){
            return new AliPayStorageService(config);
        }else if(Integer.valueOf(config.getType())  == Constant.PayService.WECHATPAY.getValue()){
            return new WechatPayStorageService(config);
        }

        return null;
    }

}
