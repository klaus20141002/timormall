package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.OrderFoods;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public interface IOrderFoodsService {
	
	OrderFoods queryObject(Long id);
	
	List<OrderFoods> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderFoods orderFoods);
	
	void update(OrderFoods orderFoods);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
