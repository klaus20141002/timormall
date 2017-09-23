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
import com.klauting.timormall.system.api.entity.GoodsExt;
import com.klauting.timormall.system.api.service.IGoodsExtService;

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
@RequestMapping("/api/{version}/goodsext")
@Api(tags = "商品拓展信息")
public class GoodsExtController {
	@Autowired
	private IGoodsExtService goodsExtService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('goodsext:list')")
	@ApiOperation(value="查看商品拓展信息列表")
	public R list(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<GoodsExt> goodsExtList = goodsExtService.queryList(query);
		int total = goodsExtService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(goodsExtList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('goodsext:info')")
	@ApiOperation(value="查看商品拓展信息")
	public R info(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@PathVariable("id") Long id){
		GoodsExt goodsExt = goodsExtService.queryObject(id);
		
		return R.ok().put("goodsExt", goodsExt);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
	//@RequiresPermissions("goodsext:save")
	//@PreAuthorize("hasAuthority('goodsext:save')")
	@ApiOperation(value="保存商品拓展信息")
	public R save(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsExt goodsExt){
		goodsExtService.save(goodsExt);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
	//@RequiresPermissions("goodsext:update")
	//@PreAuthorize("hasAuthority('goodsext:update')")
	@ApiOperation(value="更新商品拓展信息")
	public R update(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody GoodsExt goodsExt){
		goodsExtService.update(goodsExt);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
	//@RequiresPermissions("goodsext:delete")
	//@PreAuthorize("hasAuthority('goodsext:delete')")
	@ApiOperation(value="删除商品拓展信息")
	public R delete(
		@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
		@RequestBody Long[] ids){
		goodsExtService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
