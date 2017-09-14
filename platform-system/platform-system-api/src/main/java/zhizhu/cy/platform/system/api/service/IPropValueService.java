package zhizhu.cy.platform.system.api.service;

import zhizhu.cy.platform.system.api.entity.PropValue;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public interface IPropValueService {
	
	PropValue queryObject(Long id);
	
	List<PropValue> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PropValue propValue);
	
	void update(PropValue propValue);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
