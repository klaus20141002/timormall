package cn.zhangxd.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.zhangxd.platform.system.provider.mapper.FoodTagMapper;
import cn.zhangxd.platform.system.api.entity.FoodTag;
import cn.zhangxd.platform.system.api.service.IFoodTagService;



@Service("foodTagService")
public class FoodTagServiceImpl implements IFoodTagService {
	@Autowired
	private FoodTagMapper foodTagMapper;
	
	@Override
	public FoodTag queryObject(Long id){
		return foodTagMapper.queryObject(id);
	}
	
	@Override
	public List<FoodTag> queryList(Map<String, Object> map){
		return foodTagMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return foodTagMapper.queryTotal(map);
	}
	
	@Override
	public void save(FoodTag foodTag){
		foodTagMapper.save(foodTag);
	}
	
	@Override
	public void update(FoodTag foodTag){
		foodTagMapper.update(foodTag);
	}
	
	@Override
	public void delete(Long id){
		foodTagMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		foodTagMapper.deleteBatch(ids);
	}
	
}
