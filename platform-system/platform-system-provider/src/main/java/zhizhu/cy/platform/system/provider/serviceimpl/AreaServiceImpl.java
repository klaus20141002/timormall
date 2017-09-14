package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import zhizhu.cy.platform.system.provider.mapper.AreaMapper;
import zhizhu.cy.platform.system.api.entity.Area;
import zhizhu.cy.platform.system.api.service.IAreaService;



@Service("areaService")
public class AreaServiceImpl implements IAreaService {
	@Autowired
	private AreaMapper areaMapper;
	
	@Override
	public Area queryObject(Long id){
		return areaMapper.queryObject(id);
	}
	
	@Override
	public List<Area> queryList(Map<String, Object> map){
		return areaMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return areaMapper.queryTotal(map);
	}
	
	@Override
	public void save(Area area){
		areaMapper.save(area);
	}
	
	@Override
	public void update(Area area){
		areaMapper.update(area);
	}
	
	@Override
	public void delete(Long id){
		areaMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		areaMapper.deleteBatch(ids);
	}
	
}
