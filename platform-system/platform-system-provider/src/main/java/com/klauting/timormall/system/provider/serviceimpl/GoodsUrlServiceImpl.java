package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.GoodsUrlMapper;
import com.klauting.timormall.system.api.entity.GoodsUrl;
import com.klauting.timormall.system.api.service.IGoodsUrlService;



@Service("goodsUrlService")
public class GoodsUrlServiceImpl implements IGoodsUrlService {
	@Autowired
	private GoodsUrlMapper goodsUrlMapper;
	
	@Override
	public GoodsUrl queryObject(Long id){
		return goodsUrlMapper.queryObject(id);
	}
	
	@Override
	public List<GoodsUrl> queryList(Map<String, Object> map){
		return goodsUrlMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsUrlMapper.queryTotal(map);
	}
	
	@Override
	public void save(GoodsUrl goodsUrl){
		goodsUrlMapper.save(goodsUrl);
	}
	
	@Override
	public void update(GoodsUrl goodsUrl){
		goodsUrlMapper.update(goodsUrl);
	}
	
	@Override
	public void delete(Long id){
		goodsUrlMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		goodsUrlMapper.deleteBatch(ids);
	}
	
}
