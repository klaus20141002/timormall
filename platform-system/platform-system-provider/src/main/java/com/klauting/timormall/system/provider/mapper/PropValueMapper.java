package com.klauting.timormall.system.provider.mapper;

import com.klauting.timormall.system.api.entity.PropValue;

import org.apache.ibatis.annotations.Mapper;

import com.klauting.timormall.common.service.dao.BizDao;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
@Mapper
public interface PropValueMapper extends BizDao<PropValue> {
	
}
