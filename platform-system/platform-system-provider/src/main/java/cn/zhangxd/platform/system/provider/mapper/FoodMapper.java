package cn.zhangxd.platform.system.provider.mapper;

import cn.zhangxd.platform.system.api.entity.Food;

import org.apache.ibatis.annotations.Mapper;

import cn.zhangxd.platform.common.service.dao.BizDao;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@Mapper
public interface FoodMapper extends BizDao<Food> {
	
}
