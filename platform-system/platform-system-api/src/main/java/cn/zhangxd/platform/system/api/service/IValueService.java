package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.Value;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public interface IValueService {
	
	Value queryObject(Long id);
	
	List<Value> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Value value);
	
	void update(Value value);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
