package cn.zhangxd.platform.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zhangxd.platform.admin.web.common.controller.BaseController;
import cn.zhangxd.platform.admin.web.util.PageUtils;
import cn.zhangxd.platform.admin.web.util.Query;
import cn.zhangxd.platform.admin.web.util.R;
import cn.zhangxd.platform.system.api.entity.Order;
import cn.zhangxd.platform.system.api.service.IOrderService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:32
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController{
	@Autowired
	private IOrderService orderService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@PreAuthorize("hasAuthority('order:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Order> orderList = orderService.queryList(query);
		int total = orderService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@PreAuthorize("hasAuthority('order:info')")
	public R info(@PathVariable("id") Long id){
		Order order = orderService.queryObject(id);
		
		return R.ok().put("order", order);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("order:save")
	@PreAuthorize("hasAuthority('order:save')")
	public R save(@RequestBody Order order){
		orderService.save(order);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("order:update")
	@PreAuthorize("hasAuthority('order:update')")
	public R update(@RequestBody Order order){
		orderService.update(order);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("order:delete")
	@PreAuthorize("hasAuthority('order:delete')")
	public R delete(@RequestBody Long[] ids){
		orderService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
