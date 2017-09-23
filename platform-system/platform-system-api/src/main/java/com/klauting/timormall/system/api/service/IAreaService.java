package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.entity.Area;

import java.util.List;
import java.util.Map;

/**
 * 餐饮-地址-区域选择表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public interface IAreaService {
	
	Area queryObject(Long id);
	
	List<Area> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Area area);
	
	void update(Area area);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
