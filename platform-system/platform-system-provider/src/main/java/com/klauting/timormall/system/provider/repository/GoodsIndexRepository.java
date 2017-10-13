/******************************************************************************
 * @File name   :      GoodsIndexRepository.java
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
 * 2017年10月11日 下午7:54:02        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.provider.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.klauting.timormall.system.api.entity.GoodsIndex;

public interface GoodsIndexRepository extends SolrCrudRepository<GoodsIndex, String> {
	
	
	List<GoodsIndex> findByName(String name);


	// 可以把@Query注释掉， findByNameContaining就变成了 name:*?0*，仅按名称匹配
	@Query(value = "name:*?0* or category:*?0*")
	Page<GoodsIndex> findByNameContaining(String name, Pageable pageable);
	
	
	
	
	
}

