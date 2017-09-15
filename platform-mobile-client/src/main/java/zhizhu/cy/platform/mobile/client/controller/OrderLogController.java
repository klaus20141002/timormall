package zhizhu.cy.platform.mobile.client.controller;

import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import zhizhu.cy.platform.mobile.client.util.PageUtils;
import zhizhu.cy.platform.mobile.client.util.Query;
import zhizhu.cy.platform.mobile.client.util.R;
import zhizhu.cy.platform.system.api.entity.OrderLog;
import zhizhu.cy.platform.system.api.service.IOrderLogService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-14 17:46:37
 */
@RestController
@RequestMapping("/api/{version}/orderlog")
@Api(tags = "订单日志")
public class OrderLogController {
	@Autowired
	private IOrderLogService orderLogService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('orderlog:list')")
	@ApiOperation(value = "查看订单日志列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "过滤条件，分页，排序 等数据", defaultValue = "{}") @RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderLog> orderLogList = orderLogService.queryList(query);
		int total = orderLogService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderLogList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('orderlog:info')")
	@ApiOperation(value = "查看订单日志")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "ID", defaultValue = "0") @PathVariable("id") Long id){
		OrderLog orderLog = orderLogService.queryObject(id);
		
		return R.ok().put("orderLog", orderLog);
	}
	
}
