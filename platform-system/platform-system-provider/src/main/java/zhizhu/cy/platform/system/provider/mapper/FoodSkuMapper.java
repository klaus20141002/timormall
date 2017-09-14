package zhizhu.cy.platform.system.provider.mapper;

import zhizhu.cy.platform.system.api.entity.FoodSku;

import org.apache.ibatis.annotations.Mapper;

import zhizhu.cy.platform.common.service.dao.BizDao;

/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@Mapper
public interface FoodSkuMapper extends BizDao<FoodSku> {
	
}
