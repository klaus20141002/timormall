package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.Tag;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface ITagService {
	
	Tag queryObject(Long id);
	
	List<Tag> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Tag tag);
	
	void update(Tag tag);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
