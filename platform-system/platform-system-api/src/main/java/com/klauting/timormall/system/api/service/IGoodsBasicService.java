package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.dto.GoodsBasicDto;
import com.klauting.timormall.system.api.entity.GoodsBasic;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public interface IGoodsBasicService {
	
	GoodsBasic queryObject(Long id);
	
	GoodsBasicDto queryGoodsIdAndPlatformId(Long goodsId,int platformId);
	
	
	List<GoodsBasicDto> queryGoodsBasicDtoList(Map<String, Object> map);
	List<GoodsBasic> queryList(Map<String, Object> map);
	List<GoodsBasic> queryListForSpider(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(GoodsBasic goodsBasic);
	
	void update(GoodsBasic goodsBasic);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
