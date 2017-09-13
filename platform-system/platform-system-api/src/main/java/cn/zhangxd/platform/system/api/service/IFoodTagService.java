package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.FoodTag;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface IFoodTagService {
	
	FoodTag queryObject(Long id);
	
	List<FoodTag> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FoodTag foodTag);
	
	void update(FoodTag foodTag);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
