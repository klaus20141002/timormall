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

import zhizhu.cy.platform.admin.web.common.controller.BaseController;
import zhizhu.cy.platform.admin.web.util.PageUtils;
import zhizhu.cy.platform.admin.web.util.Query;
import zhizhu.cy.platform.admin.web.util.R;
import zhizhu.cy.platform.system.api.entity.Categery;
import zhizhu.cy.platform.system.api.service.ICategeryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:32
 */
@RestController
@RequestMapping("/sys/{version}/categery")
@Api(tags = "分类管理")
public class CategeryController extends BaseController{
	@Autowired
	private ICategeryService categeryService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@PreAuthorize("hasAuthority('categery:list')")
	@ApiOperation(value = "查看分裂列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "分页及排序") @RequestParam(required = false) Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Categery> categeryList = categeryService.queryList(query);
		int total = categeryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(categeryList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	@PreAuthorize("hasAuthority('categery:info')")
	@ApiOperation(value = "查看分裂详情")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "ID" ,defaultValue = "1") @PathVariable("id") Long id){
		Categery categery = categeryService.queryObject(id);
		
		return R.ok().put("categery", categery);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("categery:save")
	@PreAuthorize("hasAuthority('categery:save')")
	@ApiOperation(value = "保存分裂")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Categery categery){
		categeryService.save(categery);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("categery:update")
	@PreAuthorize("hasAuthority('categery:update')")
	@ApiOperation(value = "更新分裂")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Categery categery){
		categeryService.update(categery);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("categery:delete")
	@PreAuthorize("hasAuthority('categery:delete')")
	@ApiOperation(value = "删除分裂")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Long[] ids){
		categeryService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
