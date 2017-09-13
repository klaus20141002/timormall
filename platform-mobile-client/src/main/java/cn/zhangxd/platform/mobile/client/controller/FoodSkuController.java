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
import cn.zhangxd.platform.system.api.entity.FoodSku;
import cn.zhangxd.platform.system.api.service.IFoodSkuService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@RestController
@RequestMapping("/api/{version}/foodsku")
public class FoodSkuController {
	@Autowired
	private IFoodSkuService foodSkuService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('foodsku:list')")
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
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('foodsku:info')")
	public R info(@PathVariable("id") Long id){
		FoodSku foodSku = foodSkuService.queryObject(id);
		
		return R.ok().put("foodSku", foodSku);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("foodsku:save")
	//@PreAuthorize("hasAuthority('foodsku:save')")
	public R save(@RequestBody FoodSku foodSku){
		foodSkuService.save(foodSku);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("foodsku:update")
	//@PreAuthorize("hasAuthority('foodsku:update')")
	public R update(@RequestBody FoodSku foodSku){
		foodSkuService.update(foodSku);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("foodsku:delete")
	//@PreAuthorize("hasAuthority('foodsku:delete')")
	public R delete(@RequestBody Long[] ids){
		foodSkuService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
