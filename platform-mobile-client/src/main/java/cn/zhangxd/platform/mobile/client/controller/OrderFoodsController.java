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
import cn.zhangxd.platform.system.api.entity.OrderFoods;
import cn.zhangxd.platform.system.api.service.IOrderFoodsService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
@RestController
@RequestMapping("/api/{version}/orderfoods")
public class OrderFoodsController {
	@Autowired
	private IOrderFoodsService orderFoodsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('orderfoods:list')")
	public R list(@RequestParam Map<String, Object> params){
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
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('orderfoods:info')")
	public R info(@PathVariable("id") Long id){
		OrderFoods orderFoods = orderFoodsService.queryObject(id);
		
		return R.ok().put("orderFoods", orderFoods);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("orderfoods:save")
	//@PreAuthorize("hasAuthority('orderfoods:save')")
	public R save(@RequestBody OrderFoods orderFoods){
		orderFoodsService.save(orderFoods);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("orderfoods:update")
	//@PreAuthorize("hasAuthority('orderfoods:update')")
	public R update(@RequestBody OrderFoods orderFoods){
		orderFoodsService.update(orderFoods);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("orderfoods:delete")
	//@PreAuthorize("hasAuthority('orderfoods:delete')")
	public R delete(@RequestBody Long[] ids){
		orderFoodsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
