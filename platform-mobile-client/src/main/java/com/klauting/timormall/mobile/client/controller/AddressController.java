package com.klauting.timormall.mobile.client.controller;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.klauting.timormall.mobile.client.util.PageUtils;
import com.klauting.timormall.mobile.client.util.Query;
import com.klauting.timormall.mobile.client.util.R;
import com.klauting.timormall.system.api.entity.Address;
import com.klauting.timormall.system.api.service.IAddressService;


/**
 * 餐饮-地址表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:21
 */
@RestController
@RequestMapping("/api/{version}/address")
@Api(tags = "地址管理")
public class AddressController {
	@Autowired
	private IAddressService addressService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('address:list')")
	@ApiOperation(value = "获取地址列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "过滤条件，分页，排序 等数据", defaultValue = "{}") @RequestParam Map<String, Object> params){
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
	@ApiOperation(value = "查看地址")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "地址ID数组", defaultValue = "0")@PathVariable("id") Long id){
		Address address = addressService.queryObject(id);
		
		return R.ok().put("address", address);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("address:save")
	@PreAuthorize("hasAuthority('address:save')")
	@ApiOperation(value = "新增地址")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Address address){
		addressService.save(address);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("address:update")
	@PreAuthorize("hasAuthority('address:update')")
	@ApiOperation(value = "更新地址")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Address address){
		addressService.update(address);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("address:delete")
	@PreAuthorize("hasAuthority('address:delete')")
	@ApiOperation(value = "删除地址")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "地址ID数组", defaultValue = "[]") @RequestBody Long[] ids){
		addressService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
