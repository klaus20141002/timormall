package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.entity.Ad;

import java.util.List;
import java.util.Map;

/**
 * 广告位表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public interface IAdService {
	
	Ad queryObject(Long id);
	
	List<Ad> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Ad ad);
	
	void update(Ad ad);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
