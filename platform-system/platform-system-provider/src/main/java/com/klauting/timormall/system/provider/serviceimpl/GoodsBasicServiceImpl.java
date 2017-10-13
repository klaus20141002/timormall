package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.GoodsBasicMapper;
import com.klauting.timormall.system.api.dto.GoodsBasicDto;
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

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年9月27日
	 * @see com.klauting.timormall.system.api.service.IGoodsBasicService#queryGoodsIdAndPlatformId(java.lang.Long, java.lang.Long)
	**/
	@Override
	public GoodsBasicDto queryGoodsIdAndPlatformId(Long goodsId, int platformId) {
		// TODO Auto-generated method stub
		return goodsBasicMapper.queryGoodsIdAndPlatformId(goodsId,platformId);
	}

	/**
	 * {@inheritDoc} 
	 * overridden:
	 * @Date        :      2017年10月9日
	 * @see com.klauting.timormall.system.api.service.IGoodsBasicService#queryGoodsBasicDtoList(java.util.Map)
	**/
	@Override
	public List<GoodsBasicDto> queryGoodsBasicDtoList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsBasicMapper.queryGoodsBasicDtoList(map);
	}
	
}
