package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.entity.GoodsExt;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public interface IGoodsExtService {
	
	GoodsExt queryObject(Long id);
	
	List<GoodsExt> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsExt goodsExt);
	
	void update(GoodsExt goodsExt);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
