package cn.zhangxd.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.zhangxd.platform.system.provider.mapper.OrderLogMapper;
import cn.zhangxd.platform.system.api.entity.OrderLog;
import cn.zhangxd.platform.system.api.service.IOrderLogService;



@Service("orderLogService")
public class OrderLogServiceImpl implements IOrderLogService {
	@Autowired
	private OrderLogMapper orderLogMapper;
	
	@Override
	public OrderLog queryObject(Long id){
		return orderLogMapper.queryObject(id);
	}
	
	@Override
	public List<OrderLog> queryList(Map<String, Object> map){
		return orderLogMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderLogMapper.queryTotal(map);
	}
	
	@Override
	public void save(OrderLog orderLog){
		orderLogMapper.save(orderLog);
	}
	
	@Override
	public void update(OrderLog orderLog){
		orderLogMapper.update(orderLog);
	}
	
	@Override
	public void delete(Long id){
		orderLogMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		orderLogMapper.deleteBatch(ids);
	}
	
}
