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
import zhizhu.cy.platform.admin.web.common.controller.BaseController;
import zhizhu.cy.platform.admin.web.util.PageUtils;
import zhizhu.cy.platform.admin.web.util.Query;
import zhizhu.cy.platform.admin.web.util.R;
import zhizhu.cy.platform.system.api.entity.FoodSku;
import zhizhu.cy.platform.system.api.service.IFoodSkuService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:32
 */
@RestController
@RequestMapping("/sys/{version}/foodsku")
@Api(tags="菜品SKU管理")
public class FoodSkuController extends BaseController{
	@Autowired
	private IFoodSkuService foodSkuService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('foodsku:list')")
	@ApiOperation(value = "查看菜品SKU列表")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FoodSku> foodSkuList = foodSkuService.queryList(query);
		int total = foodSkuService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(foodSkuList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
//	@PreAuthorize("hasAuthority('foodsku:info')")
	@ApiOperation(value = "查看菜品SKU")
	public R info(@PathVariable("id") Long id){
		FoodSku foodSku = foodSkuService.queryObject(id);
		
		return R.ok().put("foodSku", foodSku);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("foodsku:save")
//	@PreAuthorize("hasAuthority('foodsku:save')")
	@ApiOperation(value = "新增菜品SKU")
	public R save(@RequestBody FoodSku foodSku){
		foodSkuService.save(foodSku);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("foodsku:update")
//	@PreAuthorize("hasAuthority('foodsku:update')")
	@ApiOperation(value = "更新菜品SKU")
	public R update(@RequestBody FoodSku foodSku){
		foodSkuService.update(foodSku);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("foodsku:delete")
	@PreAuthorize("hasAuthority('foodsku:delete')")
	@ApiOperation(value = "删除菜品SKU")
	public R delete(@RequestBody Long[] ids){
		foodSkuService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
