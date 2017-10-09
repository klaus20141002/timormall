package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.entity.GoodsAd;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public interface IGoodsAdService {
	
	GoodsAd queryObject(Long id);
	GoodsAd queryByAdName(String adName);
	
	List<GoodsAd> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsAd goodsAd);
	
	void update(GoodsAd goodsAd);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
