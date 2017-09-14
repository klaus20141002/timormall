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
@RequestMapping("orderlog")
public class OrderLogController {
	@Autowired
	private IOrderLogService orderLogService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('orderlog:list')")
	public R list(@RequestParam Map<String, Object> params){
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
	public R info(@PathVariable("id") Long id){
		OrderLog orderLog = orderLogService.queryObject(id);
		
		return R.ok().put("orderLog", orderLog);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("orderlog:save")
	//@PreAuthorize("hasAuthority('orderlog:save')")
	public R save(@RequestBody OrderLog orderLog){
		orderLogService.save(orderLog);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("orderlog:update")
	//@PreAuthorize("hasAuthority('orderlog:update')")
	public R update(@RequestBody OrderLog orderLog){
		orderLogService.update(orderLog);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("orderlog:delete")
	//@PreAuthorize("hasAuthority('orderlog:delete')")
	public R delete(@RequestBody Long[] ids){
		orderLogService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
