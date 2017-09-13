package cn.zhangxd.platform.system.provider.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import cn.zhangxd.platform.system.provider.mapper.AddressMapper;
import cn.zhangxd.platform.system.api.entity.Address;
import cn.zhangxd.platform.system.api.service.IAddressService;



@Service("addressService")
@Transactional
public class AddressServiceImpl implements IAddressService {
	@Autowired
	private AddressMapper addressMapper;
	
	@Override
	public Address queryObject(Long id){
		return addressMapper.queryObject(id);
	}
	
	@Override
	public List<Address> queryList(Map<String, Object> map){
		return addressMapper.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return addressMapper.queryTotal(map);
	}
	
	@Override
	public void save(Address address){
		addressMapper.save(address);
	}
	
	@Override
	public void update(Address address){
		addressMapper.update(address);
	}
	
	@Override
	public void delete(Long id){
		addressMapper.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		addressMapper.deleteBatch(ids);
	}
	
}
