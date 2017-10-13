package com.klauting.timormall.system.provider.mapper;

import com.klauting.timormall.system.api.dto.GoodsBasicDto;
import com.klauting.timormall.system.api.entity.GoodsBasic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.klauting.timormall.common.service.dao.BizDao;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
@Mapper
public interface GoodsBasicMapper extends BizDao<GoodsBasic> {
	
	GoodsBasicDto queryGoodsIdAndPlatformId(@Param("goodsId") Long goodsId,@Param("platformId") int platformId);
	
	List<GoodsBasicDto> queryGoodsBasicDtoList(Map<String, Object> map);
	
}
