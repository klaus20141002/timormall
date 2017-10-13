/******************************************************************************
 * @File name   :      IGoodsIndexService.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年10月11日
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
 * 2017年10月11日 下午7:58:32        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.klauting.timormall.system.api.entity.GoodsIndex;

/**
 *@author niklaus mikaelson
 */
public interface IGoodsIndexService {
	
	
	/**
	 * @Date        :      2017年10月11日
	 * @param name
	 * @return
	 */
	public List<GoodsIndex> findByName(String name) ;
	
	/**
	 * @Date        :      2017年10月11日
	 * @param product
	 */
	public void save(GoodsIndex product) ;
	
	/**
	 * @Date        :      2017年10月11日
	 * @param queryString
	 * @param pageable
	 * @return
	 */
	public Page<GoodsIndex> query(String queryString, Pageable pageable) ;
	
	/**
	 * @Date        :      2017年10月11日
	 * @param goods
	 * @return
	 */
	public Iterable<GoodsIndex> synGoodsToSolr(List<GoodsIndex> goods) ;

}
