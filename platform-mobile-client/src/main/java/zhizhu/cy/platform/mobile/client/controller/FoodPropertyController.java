package zhizhu.cy.platform.mobile.client.controller;

import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zhizhu.cy.platform.mobile.client.util.PageUtils;
import zhizhu.cy.platform.mobile.client.util.Query;
import zhizhu.cy.platform.mobile.client.util.R;
import zhizhu.cy.platform.system.api.entity.FoodProperty;
import zhizhu.cy.platform.system.api.service.IFoodPropertyService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@RestController
@RequestMapping("/api/{version}/foodproperty")
public class FoodPropertyController {
	@Autowired
	private IFoodPropertyService foodPropertyService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('foodproperty:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<FoodProperty> foodPropertyList = foodPropertyService.queryList(query);
		int total = foodPropertyService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(foodPropertyList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('foodproperty:info')")
	public R info(@PathVariable("id") Long id){
		FoodProperty foodProperty = foodPropertyService.queryObject(id);
		
		return R.ok().put("foodProperty", foodProperty);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("foodproperty:save")
	//@PreAuthorize("hasAuthority('foodproperty:save')")
	public R save(@RequestBody FoodProperty foodProperty){
		foodPropertyService.save(foodProperty);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("foodproperty:update")
	//@PreAuthorize("hasAuthority('foodproperty:update')")
	public R update(@RequestBody FoodProperty foodProperty){
		foodPropertyService.update(foodProperty);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("foodproperty:delete")
	//@PreAuthorize("hasAuthority('foodproperty:delete')")
	public R delete(@RequestBody Long[] ids){
		foodPropertyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
