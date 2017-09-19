package zhizhu.cy.platform.admin.web.controller;

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
import zhizhu.cy.platform.admin.web.common.controller.BaseController;
import zhizhu.cy.platform.admin.web.util.PageUtils;
import zhizhu.cy.platform.admin.web.util.Query;
import zhizhu.cy.platform.admin.web.util.R;
import zhizhu.cy.platform.system.api.entity.FoodProperty;
import zhizhu.cy.platform.system.api.service.IFoodPropertyService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:32
 */
@RestController
@RequestMapping("/sys/{version}/foodproperty")
@Api(tags="菜品属性管理")
public class FoodPropertyController extends BaseController{
	@Autowired
	private IFoodPropertyService foodPropertyService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('foodproperty:list')")
	@ApiOperation(value = "查看菜品属性列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "分页及排序", defaultValue = "{'page':'1','pagesize':'20'}") @RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FoodProperty> foodPropertyList = foodPropertyService.queryList(query);
		int total = foodPropertyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(foodPropertyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
//	@PreAuthorize("hasAuthority('foodproperty:info')")
	@ApiOperation(value = "查看菜品属性")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@PathVariable("id") Long id){
		FoodProperty foodProperty = foodPropertyService.queryObject(id);
		
		return R.ok().put("foodProperty", foodProperty);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("foodproperty:save")
//	@PreAuthorize("hasAuthority('foodproperty:save')")
	@ApiOperation(value = "新增菜品属性")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody FoodProperty foodProperty){
		foodPropertyService.save(foodProperty);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("foodproperty:update")
//	@PreAuthorize("hasAuthority('foodproperty:update')")
	@ApiOperation(value = "更新菜品属性")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody FoodProperty foodProperty){
		foodPropertyService.update(foodProperty);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("foodproperty:delete")
//	@PreAuthorize("hasAuthority('foodproperty:delete')")
	@ApiOperation(value = "删除菜品属性")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Long[] ids){
		foodPropertyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
