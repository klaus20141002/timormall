package cn.zhangxd.platform.mobile.client.controller;

import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zhangxd.platform.mobile.client.util.PageUtils;
import cn.zhangxd.platform.mobile.client.util.Query;
import cn.zhangxd.platform.mobile.client.util.R;
import cn.zhangxd.platform.system.api.entity.Food;
import cn.zhangxd.platform.system.api.service.IFoodService;
import io.swagger.annotations.Api;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@RestController
@RequestMapping("/api/{version}/food")
@Api(tags = "菜品")
public class FoodController {
	@Autowired
	private IFoodService foodService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('food:list')")
	public R list(@RequestParam Map<String, Object> params){
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
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('food:info')")
	public R info(@PathVariable("id") Long id){
		Food food = foodService.queryObject(id);
		
		return R.ok().put("food", food);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("food:save")
	//@PreAuthorize("hasAuthority('food:save')")
	public R save(@RequestBody Food food){
		foodService.save(food);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("food:update")
	//@PreAuthorize("hasAuthority('food:update')")
	public R update(@RequestBody Food food){
		foodService.update(food);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("food:delete")
	//@PreAuthorize("hasAuthority('food:delete')")
	public R delete(@RequestBody Long[] ids){
		foodService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
