package com.klauting.timormall.system.provider.mapper;

import com.klauting.timormall.system.api.entity.Address;

import org.apache.ibatis.annotations.Mapper;

import com.klauting.timormall.common.service.dao.BizDao;

/**
 * 餐饮-地址表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:48
 */
@Mapper
public interface AddressMapper extends BizDao<Address> {
	
}
