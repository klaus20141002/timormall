package zhizhu.cy.platform.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
import zhizhu.cy.platform.system.api.entity.Desk;
import zhizhu.cy.platform.system.api.service.IDeskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 
 * 
 * @author niklaus miakelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-07 16:53:39
 */
@RestController
@RequestMapping("/sys/{version}/desk")
@Api(tags = "桌子管理")
@Validated
public class DeskController extends BaseController {
	@Autowired
	private IDeskService deskService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查看椅子列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "分页及排序", defaultValue = "{}") @RequestParam(required =false) Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Desk> deskList = deskService.queryList(query);
		int total = deskService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(deskList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
//	@RequiresPermissions("desk:info")
	@ApiOperation(value = "查看椅子详情")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "ID", defaultValue = "1") @PathVariable("id") Long id){
		Desk desk = deskService.queryObject(id);
		
		return R.ok().put("desk", desk);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
//	@RequiresPermissions("desk:save")
	@ApiOperation(value = "保存椅子")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "椅子") @RequestBody Desk desk){
		deskService.save(desk);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
//	@RequiresPermissions("desk:update")
	@ApiOperation(value = "更新椅子")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "椅子") @RequestBody Desk desk){
		deskService.update(desk);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
//	@RequiresPermissions("desk:delete")
	@ApiOperation(value = "删除椅子")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "数组") @RequestBody(required=true) Long[] ids){
		deskService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
