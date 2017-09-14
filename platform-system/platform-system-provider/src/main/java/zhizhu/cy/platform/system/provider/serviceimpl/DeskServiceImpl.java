package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import zhizhu.cy.platform.system.provider.mapper.DeskMapper;
import zhizhu.cy.platform.system.api.entity.Desk;
import zhizhu.cy.platform.system.api.service.IDeskService;



@Service("deskService")
public class DeskServiceImpl implements IDeskService {
	@Autowired
	private DeskMapper deskMapper;
	
	@Override
	public Desk queryObject(Long id){
		return deskMapper.queryObject(id);
	}
	
	@Override
	public List<Desk> queryList(Map<String, Object> map){
		return deskMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return deskMapper.queryTotal(map);
	}
	
	@Override
	public void save(Desk desk){
		deskMapper.save(desk);
	}
	
	@Override
	public void update(Desk desk){
		deskMapper.update(desk);
	}
	
	@Override
	public void delete(Long id){
		deskMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		deskMapper.deleteBatch(ids);
	}
	
}
