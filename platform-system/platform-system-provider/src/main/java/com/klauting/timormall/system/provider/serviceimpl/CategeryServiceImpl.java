package com.klauting.timormall.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.klauting.timormall.system.provider.mapper.CategeryMapper;
import com.klauting.timormall.system.api.entity.Categery;
import com.klauting.timormall.system.api.service.ICategeryService;



@Service("categeryService")
public class CategeryServiceImpl implements ICategeryService {
	@Autowired
	private CategeryMapper categeryMapper;
	
	@Override
	public Categery queryObject(Long id){
		return categeryMapper.queryObject(id);
	}
	
	@Override
	public List<Categery> queryList(Map<String, Object> map){
		return categeryMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return categeryMapper.queryTotal(map);
	}
	
	@Override
	public void save(Categery categery){
		categeryMapper.save(categery);
	}
	
	@Override
	public void update(Categery categery){
		categeryMapper.update(categery);
	}
	
	@Override
	public void delete(Long id){
		categeryMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		categeryMapper.deleteBatch(ids);
	}
	
}
