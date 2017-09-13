package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.Food;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface IFoodService {
	
	Food queryObject(Long id);
	
	List<Food> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Food food);
	
	void update(Food food);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
