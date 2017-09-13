package cn.zhangxd.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.zhangxd.platform.system.provider.mapper.OrderMapper;
import cn.zhangxd.platform.system.api.entity.Order;
import cn.zhangxd.platform.system.api.service.IOrderService;



@Service("orderService")
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public Order queryObject(Long id){
		return orderMapper.queryObject(id);
	}
	
	@Override
	public List<Order> queryList(Map<String, Object> map){
		return orderMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderMapper.queryTotal(map);
	}
	
	@Override
	public void save(Order order){
		orderMapper.save(order);
	}
	
	@Override
	public void update(Order order){
		orderMapper.update(order);
	}
	
	@Override
	public void delete(Long id){
		orderMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		orderMapper.deleteBatch(ids);
	}
	
}
