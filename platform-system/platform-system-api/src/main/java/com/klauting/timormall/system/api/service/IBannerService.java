package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.entity.Banner;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
public interface IBannerService {
	
	Banner queryObject(Long id);
	
	List<Banner> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Banner banner);
	
	void update(Banner banner);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
