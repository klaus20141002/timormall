package zhizhu.cy.platform.system.api.service;

import zhizhu.cy.platform.system.api.entity.Categery;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface ICategeryService {
	
	Categery queryObject(Long id);
	
	List<Categery> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Categery categery);
	
	void update(Categery categery);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
