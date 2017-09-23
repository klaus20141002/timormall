package com.klauting.timormall.admin.web.controller;

import java.util.List;
import java.util.Map;

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
import com.klauting.timormall.admin.web.common.controller.BaseController;
import com.klauting.timormall.admin.web.util.PageUtils;
import com.klauting.timormall.admin.web.util.Query;
import com.klauting.timormall.admin.web.util.R;
import com.klauting.timormall.system.api.entity.Property;
import com.klauting.timormall.system.api.service.IPropertyService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:48
 */
@RestController
@RequestMapping("/sys/{version}/property")
@Api(tags="属性管理")
public class PropertyController extends BaseController{
	@Autowired
	private IPropertyService propertyService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('property:list')")
	@ApiOperation(value="查看属性列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Property> propertyList = propertyService.queryList(query);
		int total = propertyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(propertyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
//	@PreAuthorize("hasAuthority('property:info')")
	@ApiOperation(value="查看属性")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@PathVariable("id") Long id){
		Property property = propertyService.queryObject(id);
		
		return R.ok().put("property", property);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("property:save")
//	@PreAuthorize("hasAuthority('property:save')")
	@ApiOperation(value="新增属性")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Property property){
		propertyService.save(property);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("property:update")
//	@PreAuthorize("hasAuthority('property:update')")
	@ApiOperation(value="更新属性")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Property property){
		propertyService.update(property);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("property:delete")
//	@PreAuthorize("hasAuthority('property:delete')")
	@ApiOperation(value="删除属性")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Long[] ids){
		propertyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
