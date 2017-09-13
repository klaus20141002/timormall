package cn.zhangxd.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.zhangxd.platform.system.provider.mapper.FoodPropertyMapper;
import cn.zhangxd.platform.system.api.entity.FoodProperty;
import cn.zhangxd.platform.system.api.service.IFoodPropertyService;



@Service("foodPropertyService")
public class FoodPropertyServiceImpl implements IFoodPropertyService {
	@Autowired
	private FoodPropertyMapper foodPropertyMapper;
	
	@Override
	public FoodProperty queryObject(Long id){
		return foodPropertyMapper.queryObject(id);
	}
	
	@Override
	public List<FoodProperty> queryList(Map<String, Object> map){
		return foodPropertyMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return foodPropertyMapper.queryTotal(map);
	}
	
	@Override
	public void save(FoodProperty foodProperty){
		foodPropertyMapper.save(foodProperty);
	}
	
	@Override
	public void update(FoodProperty foodProperty){
		foodPropertyMapper.update(foodProperty);
	}
	
	@Override
	public void delete(Long id){
		foodPropertyMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		foodPropertyMapper.deleteBatch(ids);
	}
	
}
