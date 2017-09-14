package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import zhizhu.cy.platform.system.provider.mapper.OrderCommentMapper;
import zhizhu.cy.platform.system.api.entity.OrderComment;
import zhizhu.cy.platform.system.api.service.IOrderCommentService;



@Service("orderCommentService")
public class OrderCommentServiceImpl implements IOrderCommentService {
	@Autowired
	private OrderCommentMapper orderCommentMapper;
	
	@Override
	public OrderComment queryObject(Long id){
		return orderCommentMapper.queryObject(id);
	}
	
	@Override
	public List<OrderComment> queryList(Map<String, Object> map){
		return orderCommentMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return orderCommentMapper.queryTotal(map);
	}
	
	@Override
	public void save(OrderComment orderComment){
		orderCommentMapper.save(orderComment);
	}
	
	@Override
	public void update(OrderComment orderComment){
		orderCommentMapper.update(orderComment);
	}
	
	@Override
	public void delete(Long id){
		orderCommentMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		orderCommentMapper.deleteBatch(ids);
	}
	
}
