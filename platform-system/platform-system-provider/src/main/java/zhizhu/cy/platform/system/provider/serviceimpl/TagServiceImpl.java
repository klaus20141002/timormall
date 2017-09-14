package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import zhizhu.cy.platform.system.provider.mapper.TagMapper;
import zhizhu.cy.platform.system.api.entity.Tag;
import zhizhu.cy.platform.system.api.service.ITagService;



@Service("tagService")
public class TagServiceImpl implements ITagService {
	@Autowired
	private TagMapper tagMapper;
	
	@Override
	public Tag queryObject(Long id){
		return tagMapper.queryObject(id);
	}
	
	@Override
	public List<Tag> queryList(Map<String, Object> map){
		return tagMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return tagMapper.queryTotal(map);
	}
	
	@Override
	public void save(Tag tag){
		tagMapper.save(tag);
	}
	
	@Override
	public void update(Tag tag){
		tagMapper.update(tag);
	}
	
	@Override
	public void delete(Long id){
		tagMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		tagMapper.deleteBatch(ids);
	}
	
}
