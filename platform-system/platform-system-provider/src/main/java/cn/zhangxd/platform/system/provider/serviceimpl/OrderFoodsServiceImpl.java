package cn.zhangxd.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.zhangxd.platform.system.provider.mapper.OrderFoodsMapper;
import cn.zhangxd.platform.system.api.entity.OrderFoods;
import cn.zhangxd.platform.system.api.service.IOrderFoodsService;



@Service("orderFoodsService")
public class OrderFoodsServiceImpl implements IOrderFoodsService {
	@Autowired
	private OrderFoodsMapper orderFoodsMapper;
	
	@Override
	public OrderFoods queryObject(Long id){
		return orderFoodsMapper.queryObject(id);
	}
	
	@Override
	public List<OrderFoods> queryList(Map<String, Object> map){
		return orderFoodsMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderFoodsMapper.queryTotal(map);
	}
	
	@Override
	public void save(OrderFoods orderFoods){
		orderFoodsMapper.save(orderFoods);
	}
	
	@Override
	public void update(OrderFoods orderFoods){
		orderFoodsMapper.update(orderFoods);
	}
	
	@Override
	public void delete(Long id){
		orderFoodsMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		orderFoodsMapper.deleteBatch(ids);
	}
	
}
