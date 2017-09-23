package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.GoodsBasicMapper;
import com.klauting.timormall.system.api.entity.GoodsBasic;
import com.klauting.timormall.system.api.service.IGoodsBasicService;



@Service("goodsBasicService")
public class GoodsBasicServiceImpl implements IGoodsBasicService {
	@Autowired
	private GoodsBasicMapper goodsBasicMapper;
	
	@Override
	public GoodsBasic queryObject(Long id){
		return goodsBasicMapper.queryObject(id);
	}
	
	@Override
	public List<GoodsBasic> queryList(Map<String, Object> map){
		return goodsBasicMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsBasicMapper.queryTotal(map);
	}
	
	@Override
	public void save(GoodsBasic goodsBasic){
		goodsBasicMapper.save(goodsBasic);
	}
	
	@Override
	public void update(GoodsBasic goodsBasic){
		goodsBasicMapper.update(goodsBasic);
	}
	
	@Override
	public void delete(Long id){
		goodsBasicMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		goodsBasicMapper.deleteBatch(ids);
	}
	
}
