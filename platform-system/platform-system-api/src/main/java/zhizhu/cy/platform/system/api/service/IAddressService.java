package zhizhu.cy.platform.system.api.service;

import zhizhu.cy.platform.system.api.entity.Address;

import java.util.List;
import java.util.Map;

/**
 * 餐饮-地址表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:48
 */
public interface IAddressService {
	
	Address queryObject(Long id);
	
	List<Address> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Address address);
	
	void update(Address address);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
