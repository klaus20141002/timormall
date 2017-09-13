package cn.zhangxd.platform.system.provider.mapper;

import cn.zhangxd.platform.system.api.entity.Area;

import org.apache.ibatis.annotations.Mapper;

import cn.zhangxd.platform.common.service.dao.BizDao;

/**
 * 餐饮-地址-区域选择表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
@Mapper
public interface AreaMapper extends BizDao<Area> {
	
}
