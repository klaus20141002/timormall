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
import zhizhu.cy.platform.system.api.entity.PropValue;
import zhizhu.cy.platform.system.api.service.IPropValueService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:48
 */
@RestController
@RequestMapping("/sys/{version}/propvalue")
@Api(tags="菜品属性值管理")
public class PropValueController extends BaseController{
	@Autowired
	private IPropValueService propValueService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('propvalue:list')")
	@ApiOperation(value="查看菜品属性值列表")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PropValue> propValueList = propValueService.queryList(query);
		int total = propValueService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(propValueList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('propvalue:info')")
	@ApiOperation(value="查看菜品属性值")
	public R info(@PathVariable("id") Long id){
		PropValue propValue = propValueService.queryObject(id);
		
		return R.ok().put("propValue", propValue);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("propvalue:save")
	@PreAuthorize("hasAuthority('propvalue:save')")
	@ApiOperation(value="新增菜品属性值")
	public R save(@RequestBody PropValue propValue){
		propValueService.save(propValue);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("propvalue:update")
	@PreAuthorize("hasAuthority('propvalue:update')")
	@ApiOperation(value="更新菜品属性值")
	public R update(@RequestBody PropValue propValue){
		propValueService.update(propValue);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("propvalue:delete")
	@PreAuthorize("hasAuthority('propvalue:delete')")
	@ApiOperation(value="删除菜品属性值")
	public R delete(@RequestBody Long[] ids){
		propValueService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
