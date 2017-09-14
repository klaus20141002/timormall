package zhizhu.cy.platform.system.api.service;

import zhizhu.cy.platform.system.api.entity.FoodProperty;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface IFoodPropertyService {
	
	FoodProperty queryObject(Long id);
	
	List<FoodProperty> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(FoodProperty foodProperty);
	
	void update(FoodProperty foodProperty);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
