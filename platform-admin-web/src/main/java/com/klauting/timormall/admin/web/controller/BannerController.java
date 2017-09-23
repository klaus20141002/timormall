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
import com.klauting.timormall.system.api.entity.Banner;
import com.klauting.timormall.system.api.service.IBannerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-23 15:43:36
 */
@RestController
@RequestMapping("/api/{version}/banner")
@Api(tags = "Banner")
public class BannerController {
	@Autowired
	private IBannerService bannerService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('banner:list')")
	@ApiOperation(value="查看Banner列表")
	public R list(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Banner> bannerList = bannerService.queryList(query);
		int total = bannerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(bannerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('banner:info')")
	@ApiOperation(value="查看Banner")
	public R info(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@PathVariable("id") Long id){
		Banner banner = bannerService.queryObject(id);
		
		return R.ok().put("banner", banner);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("banner:save")
	//@PreAuthorize("hasAuthority('banner:save')")
	@ApiOperation(value="保存Banner")
	public R save(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Banner banner){
		bannerService.save(banner);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("banner:update")
	//@PreAuthorize("hasAuthority('banner:update')")
	@ApiOperation(value="更新Banner")
	public R update(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Banner banner){
		bannerService.update(banner);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("banner:delete")
	//@PreAuthorize("hasAuthority('banner:delete')")
	@ApiOperation(value="删除Banner")
	public R delete(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Long[] ids){
		bannerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
