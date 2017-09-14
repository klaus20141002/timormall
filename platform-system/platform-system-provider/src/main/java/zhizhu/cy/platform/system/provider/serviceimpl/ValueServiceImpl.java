package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import zhizhu.cy.platform.system.provider.mapper.ValueMapper;
import zhizhu.cy.platform.system.api.entity.Value;
import zhizhu.cy.platform.system.api.service.IValueService;



@Service("valueService")
public class ValueServiceImpl implements IValueService {
	@Autowired
	private ValueMapper valueMapper;
	
	@Override
	public Value queryObject(Long id){
		return valueMapper.queryObject(id);
	}
	
	@Override
	public List<Value> queryList(Map<String, Object> map){
		return valueMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return valueMapper.queryTotal(map);
	}
	
	@Override
	public void save(Value value){
		valueMapper.save(value);
	}
	
	@Override
	public void update(Value value){
		valueMapper.update(value);
	}
	
	@Override
	public void delete(Long id){
		valueMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		valueMapper.deleteBatch(ids);
	}
	
}
