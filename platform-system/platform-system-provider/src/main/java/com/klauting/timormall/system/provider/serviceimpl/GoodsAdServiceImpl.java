package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.GoodsAdMapper;
import com.klauting.timormall.system.api.entity.GoodsAd;
import com.klauting.timormall.system.api.service.IGoodsAdService;



@Service("goodsAdService")
public class GoodsAdServiceImpl implements IGoodsAdService {
	@Autowired
	private GoodsAdMapper goodsAdMapper;
	
	@Override
	public GoodsAd queryObject(Long id){
		return goodsAdMapper.queryObject(id);
	}
	
	@Override
	public List<GoodsAd> queryList(Map<String, Object> map){
		return goodsAdMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsAdMapper.queryTotal(map);
	}
	
	@Override
	public void save(GoodsAd goodsAd){
		goodsAdMapper.save(goodsAd);
	}
	
	@Override
	public void update(GoodsAd goodsAd){
		goodsAdMapper.update(goodsAd);
	}
	
	@Override
	public void delete(Long id){
		goodsAdMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		goodsAdMapper.deleteBatch(ids);
	}
	
}
