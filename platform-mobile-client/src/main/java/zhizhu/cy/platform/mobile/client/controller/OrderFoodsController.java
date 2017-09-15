package zhizhu.cy.platform.mobile.client.controller;

import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiParam;
import zhizhu.cy.platform.mobile.client.util.PageUtils;
import zhizhu.cy.platform.mobile.client.util.Query;
import zhizhu.cy.platform.mobile.client.util.R;
import zhizhu.cy.platform.system.api.entity.OrderFoods;
import zhizhu.cy.platform.system.api.service.IOrderFoodsService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
@RestController
@RequestMapping("/api/{version}/orderfoods")
public class OrderFoodsController {
	@Autowired
	private IOrderFoodsService orderFoodsService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('orderfoods:list')")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "过滤条件，分页，排序 等数据", defaultValue = "{}") @RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderFoods> orderFoodsList = orderFoodsService.queryList(query);
		int total = orderFoodsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderFoodsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('orderfoods:info')")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "ID", defaultValue = "0") @PathVariable("id") Long id){
		OrderFoods orderFoods = orderFoodsService.queryObject(id);
		
		return R.ok().put("orderFoods", orderFoods);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("orderfoods:save")
	//@PreAuthorize("hasAuthority('orderfoods:save')")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody OrderFoods orderFoods){
		orderFoodsService.save(orderFoods);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("orderfoods:update")
	//@PreAuthorize("hasAuthority('orderfoods:update')")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody OrderFoods orderFoods){
		orderFoodsService.update(orderFoods);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("orderfoods:delete")
	//@PreAuthorize("hasAuthority('orderfoods:delete')")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "IDS", defaultValue = "[]") @RequestBody Long[] ids){
		orderFoodsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
