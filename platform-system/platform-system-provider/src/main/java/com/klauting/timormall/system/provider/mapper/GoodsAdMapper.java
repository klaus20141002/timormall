package com.klauting.timormall.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.klauting.timormall.common.service.dao.BizDao;
import com.klauting.timormall.system.api.entity.GoodsAd;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
@Mapper
public interface GoodsAdMapper extends BizDao<GoodsAd> {
	GoodsAd queryByAdName(String adName);
	
}
