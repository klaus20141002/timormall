package com.klauting.timormall.system.provider.serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klauting.timormall.system.api.entity.SysOss;
import com.klauting.timormall.system.api.service.ISysOssService;
import com.klauting.timormall.system.provider.mapper.SysOssMapper;



@Service("sysOssService")
public class SysOssServiceImpl implements ISysOssService {
	@Autowired
	private SysOssMapper sysOssMapper;
	
	@Override
	public SysOss queryObject(Long id){
		return sysOssMapper.queryObject(id);
	}
	
	@Override
	public List<SysOss> queryList(Map<String, Object> map){
		return sysOssMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return sysOssMapper.queryTotal(map);
	}
	
	@Override
	public void save(SysOss sysOss){
		sysOssMapper.save(sysOss);
	}
	
	@Override
	public void update(SysOss sysOss){
		sysOssMapper.update(sysOss);
	}
	
	@Override
	public void delete(Long id){
		sysOssMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		sysOssMapper.deleteBatch(ids);
	}
	
}
