package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.entity.GoodsUrl;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public interface IGoodsUrlService {
	
	GoodsUrl queryObject(Long id);
	
	List<GoodsUrl> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsUrl goodsUrl);
	
	void update(GoodsUrl goodsUrl);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
