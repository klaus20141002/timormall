package cn.zhangxd.platform.system.api.service;

import cn.zhangxd.platform.system.api.entity.Merchant;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
public interface IMerchantService {
	
	Merchant queryObject(Long id);
	
	List<Merchant> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(Merchant merchant);
	
	void update(Merchant merchant);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
