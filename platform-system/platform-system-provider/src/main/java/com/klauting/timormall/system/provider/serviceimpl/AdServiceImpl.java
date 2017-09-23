package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.AdMapper;
import com.klauting.timormall.system.api.entity.Ad;
import com.klauting.timormall.system.api.service.IAdService;



@Service("adService")
public class AdServiceImpl implements IAdService {
	@Autowired
	private AdMapper adMapper;
	
	@Override
	public Ad queryObject(Long id){
		return adMapper.queryObject(id);
	}
	
	@Override
	public List<Ad> queryList(Map<String, Object> map){
		return adMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return adMapper.queryTotal(map);
	}
	
	@Override
	public void save(Ad ad){
		adMapper.save(ad);
	}
	
	@Override
	public void update(Ad ad){
		adMapper.update(ad);
	}
	
	@Override
	public void delete(Long id){
		adMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		adMapper.deleteBatch(ids);
	}
	
}
