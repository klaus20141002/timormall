package com.klauting.timormall.system.provider.mapper;

import com.klauting.timormall.system.api.entity.Ad;

import org.apache.ibatis.annotations.Mapper;

import com.klauting.timormall.common.service.dao.BizDao;

/**
 * 广告位表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
@Mapper
public interface AdMapper extends BizDao<Ad> {
	
}
