/******************************************************************************
 * @File name   :      GoodsController.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月23日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年9月23日 下午4:27:25        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.mobile.client.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klauting.timormall.mobile.client.util.PageUtils;
import com.klauting.timormall.mobile.client.util.Query;
import com.klauting.timormall.mobile.client.util.R;
import com.klauting.timormall.system.api.dto.GoodsBasicDto;
import com.klauting.timormall.system.api.service.IGoodsAdService;
import com.klauting.timormall.system.api.service.IGoodsBasicService;
import com.klauting.timormall.system.api.service.IGoodsExtService;
import com.klauting.timormall.system.api.service.IGoodsUrlService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *   http://hws.m.taobao.com/cache/wdetail/5.0/?id=548218723373
 */
@RestController
@RequestMapping("/api/{version}/goods")
@Api(tags="商品")
public class GoodsController {
	@Autowired
	private IGoodsBasicService goodsBasicService;
	
	@Autowired
	private IGoodsUrlService goodsUrlService;
	
	@Autowired
	private IGoodsExtService goodsExtService;
	
	@Autowired
	private IGoodsAdService goodsAdService;
	
	
	private static final Logger logger = LoggerFactory.getLogger( GoodsController.class );
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('address:list')")
	@ApiOperation(value = "获取地址列表",notes="获取商品列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "过滤条件，分页，排序 等数据", defaultValue = "{}") @RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
        logger.info(query.toString());
        
		List<GoodsBasicDto> addressList = goodsBasicService.queryGoodsBasicDtoList(query);
		int total = goodsBasicService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(addressList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	
}
