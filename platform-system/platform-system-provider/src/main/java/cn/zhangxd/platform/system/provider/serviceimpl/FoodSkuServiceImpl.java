package cn.zhangxd.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.zhangxd.platform.system.provider.mapper.FoodSkuMapper;
import cn.zhangxd.platform.system.api.entity.FoodSku;
import cn.zhangxd.platform.system.api.service.IFoodSkuService;



@Service("foodSkuService")
public class FoodSkuServiceImpl implements IFoodSkuService {
	@Autowired
	private FoodSkuMapper foodSkuMapper;
	
	@Override
	public FoodSku queryObject(Long id){
		return foodSkuMapper.queryObject(id);
	}
	
	@Override
	public List<FoodSku> queryList(Map<String, Object> map){
		return foodSkuMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return foodSkuMapper.queryTotal(map);
	}
	
	@Override
	public void save(FoodSku foodSku){
		foodSkuMapper.save(foodSku);
	}
	
	@Override
	public void update(FoodSku foodSku){
		foodSkuMapper.update(foodSku);
	}
	
	@Override
	public void delete(Long id){
		foodSkuMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		foodSkuMapper.deleteBatch(ids);
	}
	
}
