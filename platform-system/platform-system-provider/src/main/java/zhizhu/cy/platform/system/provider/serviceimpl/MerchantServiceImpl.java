package zhizhu.cy.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import zhizhu.cy.platform.system.provider.mapper.MerchantMapper;
import zhizhu.cy.platform.system.api.entity.Merchant;
import zhizhu.cy.platform.system.api.service.IMerchantService;



@Service("merchantService")
public class MerchantServiceImpl implements IMerchantService {
	@Autowired
	private MerchantMapper merchantMapper;
	
	@Override
	public Merchant queryObject(Long id){
		return merchantMapper.queryObject(id);
	}
	
	@Override
	public List<Merchant> queryList(Map<String, Object> map){
		return merchantMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return merchantMapper.queryTotal(map);
	}
	
	@Override
	public void save(Merchant merchant){
		merchantMapper.save(merchant);
	}
	
	@Override
	public void update(Merchant merchant){
		merchantMapper.update(merchant);
	}
	
	@Override
	public void delete(Long id){
		merchantMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		merchantMapper.deleteBatch(ids);
	}
	
}
