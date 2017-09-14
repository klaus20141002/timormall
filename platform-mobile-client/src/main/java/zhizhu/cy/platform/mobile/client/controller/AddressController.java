package zhizhu.cy.platform.mobile.client.controller;

import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zhizhu.cy.platform.mobile.client.util.PageUtils;
import zhizhu.cy.platform.mobile.client.util.Query;
import zhizhu.cy.platform.mobile.client.util.R;
import zhizhu.cy.platform.system.api.entity.Address;
import zhizhu.cy.platform.system.api.service.IAddressService;


/**
 * 餐饮-地址表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
@RestController
@RequestMapping("/api/{version}/address")
public class AddressController {
	@Autowired
	private IAddressService addressService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('address:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Address> addressList = addressService.queryList(query);
		int total = addressService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('address:info')")
	public R info(@PathVariable("id") Long id){
		Address address = addressService.queryObject(id);
		
		return R.ok().put("address", address);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("address:save")
	@PreAuthorize("hasAuthority('address:save')")
	public R save(@RequestBody Address address){
		addressService.save(address);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("address:update")
	@PreAuthorize("hasAuthority('address:update')")
	public R update(@RequestBody Address address){
		addressService.update(address);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("address:delete")
	@PreAuthorize("hasAuthority('address:delete')")
	public R delete(@RequestBody Long[] ids){
		addressService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
