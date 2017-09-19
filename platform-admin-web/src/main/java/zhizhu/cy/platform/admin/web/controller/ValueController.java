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
import io.swagger.annotations.ApiParam;
import zhizhu.cy.platform.admin.web.common.controller.BaseController;
import zhizhu.cy.platform.admin.web.util.PageUtils;
import zhizhu.cy.platform.admin.web.util.Query;
import zhizhu.cy.platform.admin.web.util.R;
import zhizhu.cy.platform.system.api.entity.Value;
import zhizhu.cy.platform.system.api.service.IValueService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:48
 */
@RestController
@RequestMapping("/sys/{version}/value")
@Api(tags="属性值管理")
public class ValueController extends BaseController{
	@Autowired
	private IValueService valueService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('value:list')")
	@ApiOperation(value="查看属性值列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Value> valueList = valueService.queryList(query);
		int total = valueService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(valueList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
//	@PreAuthorize("hasAuthority('value:info')")
	@ApiOperation(value="查看属性值")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@PathVariable("id") Long id){
		Value value = valueService.queryObject(id);
		
		return R.ok().put("value", value);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("value:save")
//	@PreAuthorize("hasAuthority('value:save')")
	@ApiOperation(value="新增属性值")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Value value){
		valueService.save(value);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("value:update")
//	@PreAuthorize("hasAuthority('value:update')")
	@ApiOperation(value="更新属性值")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Value value){
		valueService.update(value);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("value:delete")
//	@PreAuthorize("hasAuthority('value:delete')")
	@ApiOperation(value="删除属性值")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Long[] ids){
		valueService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
