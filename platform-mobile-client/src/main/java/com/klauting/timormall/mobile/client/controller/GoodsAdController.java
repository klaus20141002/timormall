package com.klauting.timormall.mobile.client.controller;

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

import com.klauting.timormall.mobile.client.util.PageUtils;
import com.klauting.timormall.mobile.client.util.Query;
import com.klauting.timormall.mobile.client.util.R;
import com.klauting.timormall.system.api.entity.GoodsAd;
import com.klauting.timormall.system.api.service.IGoodsAdService;

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
@RequestMapping("/api/{version}/goodsad")
@Api(tags = "广告位商品关系")
public class GoodsAdController {
	@Autowired
	private IGoodsAdService goodsAdService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('goodsad:list')")
	@ApiOperation(value="查看广告位商品关系列表")
	public R list(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsAd> goodsAdList = goodsAdService.queryList(query);
		int total = goodsAdService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsAdList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('goodsad:info')")
	@ApiOperation(value="查看广告位商品关系")
	public R info(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@PathVariable("id") Long id){
		GoodsAd goodsAd = goodsAdService.queryObject(id);
		
		return R.ok().put("goodsAd", goodsAd);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("goodsad:save")
	//@PreAuthorize("hasAuthority('goodsad:save')")
	@ApiOperation(value="保存广告位商品关系")
	public R save(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsAd goodsAd){
		goodsAdService.save(goodsAd);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("goodsad:update")
	//@PreAuthorize("hasAuthority('goodsad:update')")
	@ApiOperation(value="更新广告位商品关系")
	public R update(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsAd goodsAd){
		goodsAdService.update(goodsAd);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("goodsad:delete")
	//@PreAuthorize("hasAuthority('goodsad:delete')")
	@ApiOperation(value="删除广告位商品关系")
	public R delete(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Long[] ids){
		goodsAdService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
