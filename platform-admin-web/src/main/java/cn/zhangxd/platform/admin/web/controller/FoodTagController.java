package cn.zhangxd.platform.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zhangxd.platform.admin.web.common.controller.BaseController;
import cn.zhangxd.platform.admin.web.util.PageUtils;
import cn.zhangxd.platform.admin.web.util.Query;
import cn.zhangxd.platform.admin.web.util.R;
import cn.zhangxd.platform.system.api.entity.FoodTag;
import cn.zhangxd.platform.system.api.service.IFoodTagService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:32
 */
@RestController
@RequestMapping("foodtag")
public class FoodTagController extends BaseController{
	@Autowired
	private IFoodTagService foodTagService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@PreAuthorize("hasAuthority('foodtag:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FoodTag> foodTagList = foodTagService.queryList(query);
		int total = foodTagService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(foodTagList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@PreAuthorize("hasAuthority('foodtag:info')")
	public R info(@PathVariable("id") Long id){
		FoodTag foodTag = foodTagService.queryObject(id);
		
		return R.ok().put("foodTag", foodTag);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("foodtag:save")
	@PreAuthorize("hasAuthority('foodtag:save')")
	public R save(@RequestBody FoodTag foodTag){
		foodTagService.save(foodTag);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("foodtag:update")
	@PreAuthorize("hasAuthority('foodtag:update')")
	public R update(@RequestBody FoodTag foodTag){
		foodTagService.update(foodTag);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("foodtag:delete")
	@PreAuthorize("hasAuthority('foodtag:delete')")
	public R delete(@RequestBody Long[] ids){
		foodTagService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
