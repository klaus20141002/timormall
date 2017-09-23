package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.GoodsExtMapper;
import com.klauting.timormall.system.api.entity.GoodsExt;
import com.klauting.timormall.system.api.service.IGoodsExtService;



@Service("goodsExtService")
public class GoodsExtServiceImpl implements IGoodsExtService {
	@Autowired
	private GoodsExtMapper goodsExtMapper;
	
	@Override
	public GoodsExt queryObject(Long id){
		return goodsExtMapper.queryObject(id);
	}
	
	@Override
	public List<GoodsExt> queryList(Map<String, Object> map){
		return goodsExtMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return goodsExtMapper.queryTotal(map);
	}
	
	@Override
	public void save(GoodsExt goodsExt){
		goodsExtMapper.save(goodsExt);
	}
	
	@Override
	public void update(GoodsExt goodsExt){
		goodsExtMapper.update(goodsExt);
	}
	
	@Override
	public void delete(Long id){
		goodsExtMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		goodsExtMapper.deleteBatch(ids);
	}
	
}
