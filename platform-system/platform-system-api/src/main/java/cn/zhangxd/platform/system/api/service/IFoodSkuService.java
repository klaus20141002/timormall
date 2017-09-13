package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.FoodSku;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface IFoodSkuService {
	
	FoodSku queryObject(Long id);
	
	List<FoodSku> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FoodSku foodSku);
	
	void update(FoodSku foodSku);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
