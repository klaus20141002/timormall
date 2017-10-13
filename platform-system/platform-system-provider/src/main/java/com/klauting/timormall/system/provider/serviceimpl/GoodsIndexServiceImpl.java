/******************************************************************************
 * @File name   :      GoodsService.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年7月20日
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
 * 2017年7月20日 下午9:33:36        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.provider.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.klauting.timormall.system.api.entity.GoodsIndex;
import com.klauting.timormall.system.api.service.IGoodsIndexService;
import com.klauting.timormall.system.provider.repository.GoodsIndexRepository;

/**
 *@author niklaus mikaelson
 */
@Service
public class GoodsIndexServiceImpl implements IGoodsIndexService {
	

    @Autowired
    GoodsIndexRepository goodsRepository;
    @Override
    public List<GoodsIndex> findByName(String name){
        if(StringUtils.isEmpty(name)){
            return new ArrayList<>();
        }
        return goodsRepository.findByName(name);
    }
    @Override
    public void save(GoodsIndex product){
        if(product != null) {
        	goodsRepository.save(product);
        }
    }
    @Override
    public Page<GoodsIndex> query(String queryString, Pageable pageable) {
        return goodsRepository.findByNameContaining(queryString, pageable);
    }
    
    
    

    /**
     * 将goods加入索引倒solr里
     * @Date        :      2017年7月20日
     * @param goods
     * @return
     */
    @Override
    public Iterable<GoodsIndex> synGoodsToSolr(List<GoodsIndex> goods) {
    	return goodsRepository.save(goods);
    }



}
