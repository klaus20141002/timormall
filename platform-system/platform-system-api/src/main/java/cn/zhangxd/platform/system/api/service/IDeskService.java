package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.Desk;

import java.util.List;
import java.util.Map;

/**
 * 餐饮，桌子表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
public interface IDeskService {
	
	Desk queryObject(Long id);
	
	List<Desk> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Desk desk);
	
	void update(Desk desk);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
