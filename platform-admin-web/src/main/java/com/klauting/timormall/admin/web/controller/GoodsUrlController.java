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
import com.klauting.timormall.system.api.entity.GoodsUrl;
import com.klauting.timormall.system.api.service.IGoodsUrlService;

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
@RequestMapping("/api/{version}/goodsurl")
@Api(tags = "商品分销信息")
public class GoodsUrlController {
	@Autowired
	private IGoodsUrlService goodsUrlService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('goodsurl:list')")
	@ApiOperation(value="查看列表商品分销信息")
	public R list(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsUrl> goodsUrlList = goodsUrlService.queryList(query);
		int total = goodsUrlService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsUrlList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('goodsurl:info')")
	@ApiOperation(value="查看商品分销信息")
	public R info(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@PathVariable("id") Long id){
		GoodsUrl goodsUrl = goodsUrlService.queryObject(id);
		
		return R.ok().put("goodsUrl", goodsUrl);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("goodsurl:save")
	//@PreAuthorize("hasAuthority('goodsurl:save')")
	@ApiOperation(value="保存商品分销信息")
	public R save(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsUrl goodsUrl){
		goodsUrlService.save(goodsUrl);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("goodsurl:update")
	//@PreAuthorize("hasAuthority('goodsurl:update')")
	@ApiOperation(value="更新商品分销信息")
	public R update(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsUrl goodsUrl){
		goodsUrlService.update(goodsUrl);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("goodsurl:delete")
	//@PreAuthorize("hasAuthority('goodsurl:delete')")
	@ApiOperation(value="删除商品分销信息")
	public R delete(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Long[] ids){
		goodsUrlService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
