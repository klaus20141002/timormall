package com.klauting.timormall.system.api.service;

import java.util.Map;

/**
 * @author niklaus mikaelson
 *
 */
public interface ISpiderService {
	
	
	
	/**
	 * 
	 */
	Map<String,Object> getGoodsDetail(String goodsId, String platformId) ;
	
	
	
	Map<String,Object> getGoodsDetailSimple(String goodsId, String platformId) ;
	
	
	
	

}
