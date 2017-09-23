package com.klauting.timormall.system.api.service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.api.entity.SysOss;

/**
 * 文件上传
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 12:13:26
 */
public interface ISysOssService {
	
	SysOss queryObject(Long id);
	
	List<SysOss> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(SysOss sysOss);
	
	void update(SysOss sysOss);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
