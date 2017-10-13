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
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.klauting.timormall.common.redis.RedisRepository;
import com.klauting.timormall.system.api.dto.GoodsBasicDto;
import com.klauting.timormall.system.api.entity.GoodsBasic;
import com.klauting.timormall.system.api.entity.GoodsIndex;
import com.klauting.timormall.system.api.service.IGoodsBasicService;
import com.klauting.timormall.system.api.service.IGoodsIndexService;
import com.klauting.timormall.system.api.service.ISpiderService;

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
    
    @Autowired
    private ISpiderService spiderService ;
    
    @Autowired
    private IGoodsIndexService goodsIndexService;
    
//    ExecutorService executorService = new 
    
    
    @Scheduled(cron = "0 0/1 * * * ? ")
	public void getGoodsDetail() {
		LOGGER.info("updateGoodsDetailImages invoked.............................");
		spiderService.getGoodsDetailSimple("42347685966", "1");
		
		
		
	}
    
    
	
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

	
//	@Scheduled(cron = "0 0/1 * * * ? ")
	public void testSolr() {
		LOGGER.info("testSolr invoked.............................");

	    
	    try{
	    	SolrDocument  doc = solrClient.getById("goods", "9057879225");
	    	System.out.println(doc.getFieldValue("name"));
	    	System.out.println(doc.getFieldValue("id"));
	    	System.out.println(doc.getFieldValue("price"));
	    	
	    	
	    	List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
	    	SolrInputDocument goods = new SolrInputDocument();
	    	
	    	goods.addField("id", "3241412423");
	    	List<String> titles = new ArrayList<String>();
	    	titles.add("A1");
	    	titles.add("A2");
	    	titles.add("D3");
	    	goods.addField("title", titles);
	    	goods.addField("name", "niklaus mikaleson");
//	    	goods.addField("mobile", "18664878092");
	    	goods.addField("category", "aliy");
	    	
	    	docs.add(goods);
	    	SolrInputDocument goods1 = new SolrInputDocument();
	    	
	    	goods1.addField("id", "324141242334");
	    	List<String> titles1 = new ArrayList<String>();
	    	titles1.add("B1");
	    	titles1.add("B2");
	    	titles1.add("C3");
	    	goods1.addField("title", titles1);
	    	goods1.addField("name", "niklaus mikaleson");
//	    	goods.addField("mobile", "18664878092");
	    	goods1.addField("category", "aliy");
	    	
	    	docs.add(goods1);
	    	
	    	
	    	UpdateResponse res = solrClient.add("goods", docs);
	    	int status = res.getStatus();
	    	LOGGER.info("status is {}",status);
	    	NamedList<Object> ressults = res.getResponse();
	    	for(Object o : ressults) {
	    		LOGGER.info("NamedList result is {}",o);
	    	}
	    	solrClient.commit("goods");
	    	
	    }catch(Exception e){
	    	LOGGER.error("testSolr error {}",e);
	    }
		
		
		
	}
	
	
	
//	@Scheduled(cron = "0 0/1 * * * ? ")
	public void testSolrJpa() {
		LOGGER.info("testSolrJpa invoked ......................................");
		GoodsBasicDto goodsBasicDto = goodsBasicService.queryGoodsIdAndPlatformId(556673643231L, 1);
		
		GoodsIndex product = new GoodsIndex();
//		product.setComment(goodsBasicDto.get);
//		product.setCoupon(goodsBasicDto.get);
		product.setName(goodsBasicDto.getGoodsTitle());
		product.setPrice(goodsBasicDto.getGoodsPrice().doubleValue());
		product.setVolume(goodsBasicDto.getVolume());
		product.setId(goodsBasicDto.getGoodsId()+""+goodsBasicDto.getPlatformId());
		goodsIndexService.save(product);
		
	}
	
}
