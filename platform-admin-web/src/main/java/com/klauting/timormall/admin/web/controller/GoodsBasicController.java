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
import com.klauting.timormall.system.api.entity.GoodsBasic;
import com.klauting.timormall.system.api.service.IGoodsBasicService;

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
@RequestMapping("/api/{version}/goodsbasic")
@Api(tags = "商品基本信息")
public class GoodsBasicController {
	@Autowired
	private IGoodsBasicService goodsBasicService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('goodsbasic:list')")
	@ApiOperation(value="查看商品基本信息列表")
	public R list(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsBasic> goodsBasicList = goodsBasicService.queryList(query);
		int total = goodsBasicService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsBasicList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('goodsbasic:info')")
	@ApiOperation(value="查看商品基本信息")
	public R info(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@PathVariable("id") Long id){
		GoodsBasic goodsBasic = goodsBasicService.queryObject(id);
		
		return R.ok().put("goodsBasic", goodsBasic);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("goodsbasic:save")
	//@PreAuthorize("hasAuthority('goodsbasic:save')")
	@ApiOperation(value="保存商品基本信息")
	public R save(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsBasic goodsBasic){
		goodsBasicService.save(goodsBasic);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("goodsbasic:update")
	//@PreAuthorize("hasAuthority('goodsbasic:update')")
	@ApiOperation(value="更新商品基本信息")
	public R update(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsBasic goodsBasic){
		goodsBasicService.update(goodsBasic);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("goodsbasic:delete")
	//@PreAuthorize("hasAuthority('goodsbasic:delete')")
	@ApiOperation(value="删除商品基本信息")
	public R delete(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Long[] ids){
		goodsBasicService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
