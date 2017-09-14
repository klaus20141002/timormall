package zhizhu.cy.platform.system.provider.mapper;

import zhizhu.cy.platform.system.api.entity.Property;

import org.apache.ibatis.annotations.Mapper;

import zhizhu.cy.platform.common.service.dao.BizDao;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */

@Mapper
public interface PropertyMapper extends BizDao<Property> {
	
}
