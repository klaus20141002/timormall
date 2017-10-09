/******************************************************************************
 * @File name   :      OrderConstant.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月15日
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
 * 2017年9月15日 上午10:19:41        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.api.constant;

/**
 *
 */
public class GlobalConstant {
	
	public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_SHORT = "yyyy-MM-dd";
	
	
	/**待接单*/
	public final static Integer ORDER_STATUS_APPLY = 1;
	/**已接单*/
	public final static Integer ORDER_STATUS_ACCEPTED = 2;
	/**用餐中*/
	public final static Integer ORDER_STATUS_EATING = 3;
	/**未支付*/
	public final static Integer ORDER_STATUS_UNPAY = 4;
	/**已支付*/
	public final static Integer ORDER_STATUS_PAYED = 5;
	/**取消*/
	public final static Integer ORDER_STATUS_CANCEL = 6;
	/**完成*/
	public final static Integer ORDER_STATUS_FINISH = 7;
	
	
	
	/**商家接单*/
	public final static Integer ORDER_OP_ACCEPTED = 1;
	/**用户支付*/
	public final static Integer ORDER_OP_PAY = 2;
	/**商家取消*/
	public final static Integer ORDER_OP_CANCEL = 3;
	/**商家退款*/
	public final static Integer ORDER_OP_REFUND = 4;
	/**用户下单*/
	public final static Integer ORDER_OP_APPLY = 5;
	
	
	
	
	/**
	 * @Date        :      2017年9月15日
	 */
	private GlobalConstant(){
		
	}
	

}
