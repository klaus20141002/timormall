package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.BannerMapper;
import com.klauting.timormall.system.api.entity.Banner;
import com.klauting.timormall.system.api.service.IBannerService;



@Service("bannerService")
public class BannerServiceImpl implements IBannerService {
	@Autowired
	private BannerMapper bannerMapper;
	
	@Override
	public Banner queryObject(Long id){
		return bannerMapper.queryObject(id);
	}
	
	@Override
	public List<Banner> queryList(Map<String, Object> map){
		return bannerMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return bannerMapper.queryTotal(map);
	}
	
	@Override
	public void save(Banner banner){
		bannerMapper.save(banner);
	}
	
	@Override
	public void update(Banner banner){
		bannerMapper.update(banner);
	}
	
	@Override
	public void delete(Long id){
		bannerMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		bannerMapper.deleteBatch(ids);
	}
	
}
