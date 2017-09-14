package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import zhizhu.cy.platform.system.provider.mapper.FoodMapper;
import zhizhu.cy.platform.system.api.entity.Food;
import zhizhu.cy.platform.system.api.service.IFoodService;



@Service("foodService")
public class FoodServiceImpl implements IFoodService {
	@Autowired
	private FoodMapper foodMapper;
	
	@Override
	public Food queryObject(Long id){
		return foodMapper.queryObject(id);
	}
	
	@Override
	public List<Food> queryList(Map<String, Object> map){
		return foodMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return foodMapper.queryTotal(map);
	}
	
	@Override
	public void save(Food food){
		foodMapper.save(food);
	}
	
	@Override
	public void update(Food food){
		foodMapper.update(food);
	}
	
	@Override
	public void delete(Long id){
		foodMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		foodMapper.deleteBatch(ids);
	}
	
}
