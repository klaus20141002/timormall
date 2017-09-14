package zhizhu.cy.platform.system.provider.mapper;

import zhizhu.cy.platform.system.api.entity.Address;

import org.apache.ibatis.annotations.Mapper;

import zhizhu.cy.platform.common.service.dao.BizDao;

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
