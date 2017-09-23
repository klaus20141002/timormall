package com.klauting.timormall.system.provider.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.klauting.timormall.common.service.dao.BizDao;
import com.klauting.timormall.system.api.entity.SysOss;

/**
 * 文件上传
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 12:13:26
 */
@Mapper
public interface SysOssMapper extends BizDao<SysOss> {
	
}
