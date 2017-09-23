package com.klauting.timormall.system.api.service;

import com.klauting.timormall.system.api.entity.Property;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public interface IPropertyService {
	
	Property queryObject(Long id);
	
	List<Property> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Property property);
	
	void update(Property property);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
