package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.OrderComment;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface IOrderCommentService {
	
	OrderComment queryObject(Long id);
	
	List<OrderComment> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OrderComment orderComment);
	
	void update(OrderComment orderComment);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
