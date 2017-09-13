package cn.zhangxd.platform.mobile.client.controller;

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

import cn.zhangxd.platform.mobile.client.common.controller.BaseController;
import cn.zhangxd.platform.mobile.client.util.PageUtils;
import cn.zhangxd.platform.mobile.client.util.Query;
import cn.zhangxd.platform.mobile.client.util.R;
import cn.zhangxd.platform.system.api.entity.Desk;
import cn.zhangxd.platform.system.api.service.IDeskService;
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
@RequestMapping("/api/{version}/desk")
@Api(tags = "桌子")
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
			@RequestParam Map<String, Object> params){
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
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@PathVariable("id") Long id){
		Desk desk = deskService.queryObject(id);
		
		return R.ok().put("desk", desk);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
//	@RequiresPermissions("desk:save")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Desk desk){
		deskService.save(desk);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
//	@RequiresPermissions("desk:update")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Desk desk){
		deskService.update(desk);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
//	@RequiresPermissions("desk:delete")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Long[] ids){
		deskService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
