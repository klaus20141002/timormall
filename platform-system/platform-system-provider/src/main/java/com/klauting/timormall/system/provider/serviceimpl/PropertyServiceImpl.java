package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.PropertyMapper;
import com.klauting.timormall.system.api.entity.Property;
import com.klauting.timormall.system.api.service.IPropertyService;



@Service("propertyService")
public class PropertyServiceImpl implements IPropertyService {
	@Autowired
	private PropertyMapper propertyMapper;
	
	@Override
	public Property queryObject(Long id){
		return propertyMapper.queryObject(id);
	}
	
	@Override
	public List<Property> queryList(Map<String, Object> map){
		return propertyMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return propertyMapper.queryTotal(map);
	}
	
	@Override
	public void save(Property property){
		propertyMapper.save(property);
	}
	
	@Override
	public void update(Property property){
		propertyMapper.update(property);
	}
	
	@Override
	public void delete(Long id){
		propertyMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		propertyMapper.deleteBatch(ids);
	}
	
}
