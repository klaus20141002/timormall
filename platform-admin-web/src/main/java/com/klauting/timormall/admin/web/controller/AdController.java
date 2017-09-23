package com.klauting.timormall.admin.web.controller;

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

import com.klauting.timormall.admin.web.util.PageUtils;
import com.klauting.timormall.admin.web.util.Query;
import com.klauting.timormall.admin.web.util.R;
import com.klauting.timormall.system.api.entity.Ad;
import com.klauting.timormall.system.api.service.IAdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 广告位表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
@RestController
@RequestMapping("/api/{version}/ad")
@Api(tags = "广告位")
public class AdController {
	@Autowired
	private IAdService adService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('ad:list')")
	@ApiOperation(value="查看广告位列表")
	public R list(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Ad> adList = adService.queryList(query);
		int total = adService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(adList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('ad:info')")
	@ApiOperation(value="查看广告位")
	public R info(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@PathVariable("id") Long id){
		Ad ad = adService.queryObject(id);
		
		return R.ok().put("ad", ad);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("ad:save")
	//@PreAuthorize("hasAuthority('ad:save')")
	@ApiOperation(value="保存广告位")
	public R save(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Ad ad){
		adService.save(ad);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("ad:update")
	//@PreAuthorize("hasAuthority('ad:update')")
	@ApiOperation(value="更新广告位")
	public R update(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Ad ad){
		adService.update(ad);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("ad:delete")
	//@PreAuthorize("hasAuthority('ad:delete')")
	@ApiOperation(value="删除广告位表")
	public R delete(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Long[] ids){
		adService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
