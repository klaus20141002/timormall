package zhizhu.cy.platform.system.api.service;

import zhizhu.cy.platform.system.api.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface IOrderService {
	
	Order queryObject(Long id);
	
	List<Order> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Order order);
	
	void update(Order order);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
