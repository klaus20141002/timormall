package zhizhu.cy.platform.mobile.client.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import zhizhu.cy.platform.common.web.util.WebUtils;
import zhizhu.cy.platform.mobile.client.security.model.AuthUser;
import zhizhu.cy.platform.mobile.client.util.PageUtils;
import zhizhu.cy.platform.mobile.client.util.Query;
import zhizhu.cy.platform.mobile.client.util.R;
import zhizhu.cy.platform.system.api.constant.OrderConstant;
import zhizhu.cy.platform.system.api.entity.Order;
import zhizhu.cy.platform.system.api.entity.OrderLog;
import zhizhu.cy.platform.system.api.service.IOrderLogService;
import zhizhu.cy.platform.system.api.service.IOrderService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
@RestController
@RequestMapping("/api/{version}/order")
@Api(tags="订单")
public class OrderController {
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderLogService orderLogService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('order:list')")
	@ApiOperation(value="查看订单列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "过滤条件，分页，排序 等数据", defaultValue = "{}") @RequestParam Map<String, Object> params){
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
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('order:info')")
	
	@ApiOperation(value="查看订单")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "ID", defaultValue = "0") @PathVariable("id") Long id){
		Order order = orderService.queryObject(id);
		
		return R.ok().put("order", order);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("order:save")
	//@PreAuthorize("hasAuthority('order:save')")
	@ApiOperation(value="下单")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Order order){
		orderService.save(order);
		OrderLog orderLog = new OrderLog();
		orderLog.setCreateTime(new Date());
		orderLog.setUpdateTime(new Date());
		orderLog.setDataStatus(1);
		orderLog.setLogDesc("order info "+order);
		orderLog.setOperationType(OrderConstant.ORDER_OP_APPLY);
		AuthUser user = WebUtils.getCurrentUser();
		
		orderLog.setUserId(user.getId());
		orderLogService.save(orderLog);
		return R.ok();
	}
	
	
	/**
	 * 保存
	 */
	@PostMapping("/update")
	//@RequiresPermissions("order:save")
	//@PreAuthorize("hasAuthority('order:save')")
	@ApiOperation(value="加菜")
	public R update (
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Order order){
		orderService.save(order);
		
		return R.ok();
	}


	
}
