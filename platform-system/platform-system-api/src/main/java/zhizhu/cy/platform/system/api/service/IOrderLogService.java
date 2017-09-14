package zhizhu.cy.platform.system.api.service;

import zhizhu.cy.platform.system.api.entity.OrderLog;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public interface IOrderLogService {
	
	OrderLog queryObject(Long id);
	
	List<OrderLog> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderLog orderLog);
	
	void update(OrderLog orderLog);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
