/******************************************************************************
 * @File name   :      TaobaoGoodsDetailService.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月28日
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
 * 2017年9月28日 上午12:08:31        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.system.provider.thirdapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.klauting.timormall.common.redis.RedisRepository;
import com.klauting.timormall.system.api.entity.GoodsBasic;
import com.klauting.timormall.system.api.service.IGoodsBasicService;

/**
 *
 */
@Service
public class TaobaoGoodsDetailService {
	
	 /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(YahooRateService.class);

    /**
     * redis repository
     */
    @Autowired
    private RedisRepository redisRepository;
    
    
	@Autowired
	private SolrClient  solrClient ;
    
    @Autowired
    private IGoodsBasicService goodsBasicService ;
    
//    ExecutorService executorService = new 
    
	
//	@Scheduled(cron = "0 0/1 * * * ? ")
	public void updateGoodsDetailImages() {
		LOGGER.info("updateGoodsDetailImages invoked.............................");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("limit", 500);
		map.put("page", 1);
		int total = goodsBasicService.queryTotal(map);
		for(int i =0 ;i<total/Integer.parseInt((String)map.get("page"));i++ ){
			List<GoodsBasic> result = goodsBasicService.queryList(map);
			for(GoodsBasic gb :result) {
				// get goods detail images
				
				
//				goodsBasicService.update(gb);
			}
			
			
			map.put("page", Integer.parseInt((String)map.get("page"))+1);
			
		}
		
		
		
	}

	
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void testSolr() {
		LOGGER.info("testSolr invoked.............................");

	    
	    try{
	    	SolrDocument  doc = solrClient.getById("goods", "9057879225");
	    	System.out.println(doc.getFieldValue("name"));
	    	System.out.println(doc.getFieldValue("id"));
	    	System.out.println(doc.getFieldValue("price"));
	    	
	    	
	    	List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
	    	SolrInputDocument goods = new SolrInputDocument();
	    	
//	    	goods.addField(name, value);
	    	
	    	docs.add(goods);
	    	
	    	
	    	solrClient.add("goods", docs);
	    	
	    	
	    }catch(Exception e){
	    	LOGGER.error("testSolr error {}",e);
	    }
		
		
		
	}
	
}
