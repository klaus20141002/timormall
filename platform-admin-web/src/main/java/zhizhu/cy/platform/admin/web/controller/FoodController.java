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

import zhizhu.cy.platform.admin.web.common.controller.BaseController;
import zhizhu.cy.platform.admin.web.util.PageUtils;
import zhizhu.cy.platform.admin.web.util.Query;
import zhizhu.cy.platform.admin.web.util.R;
import zhizhu.cy.platform.system.api.entity.Food;
import zhizhu.cy.platform.system.api.service.IFoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:32
 */
@RestController
@RequestMapping("/sys/{version}/food")
@Api(tags = "菜品管理")
public class FoodController extends BaseController{
	@Autowired
	private IFoodService foodService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('food:list')")
	@ApiOperation(value = "查看菜品列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "分页及排序") @RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Food> foodList = foodService.queryList(query);
		int total = foodService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(foodList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('food:info')")
	@ApiOperation(value = "查看菜品详情")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@PathVariable("id") Long id){
		Food food = foodService.queryObject(id);
		
		return R.ok().put("food", food);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("food:save")
	@PreAuthorize("hasAuthority('food:save')")
	@ApiOperation(value = "保存菜品")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Food food){
		foodService.save(food);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("food:update")
	@PreAuthorize("hasAuthority('food:update')")
	@ApiOperation(value = "更新菜品")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Food food){
		foodService.update(food);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("food:delete")
	@PreAuthorize("hasAuthority('food:delete')")
	@ApiOperation(value = "删除菜品")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Long[] ids){
		foodService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
