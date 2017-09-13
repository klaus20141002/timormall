package cn.zhangxd.platform.mobile.client.controller;

import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zhangxd.platform.mobile.client.util.PageUtils;
import cn.zhangxd.platform.mobile.client.util.Query;
import cn.zhangxd.platform.mobile.client.util.R;
import cn.zhangxd.platform.system.api.entity.Value;
import cn.zhangxd.platform.system.api.service.IValueService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
@RestController
@RequestMapping("/api/{version}/value")
public class ValueController {
	@Autowired
	private IValueService valueService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('value:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Value> valueList = valueService.queryList(query);
		int total = valueService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(valueList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('value:info')")
	public R info(@PathVariable("id") Long id){
		Value value = valueService.queryObject(id);
		
		return R.ok().put("value", value);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("value:save")
	//@PreAuthorize("hasAuthority('value:save')")
	public R save(@RequestBody Value value){
		valueService.save(value);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("value:update")
	//@PreAuthorize("hasAuthority('value:update')")
	public R update(@RequestBody Value value){
		valueService.update(value);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("value:delete")
	//@PreAuthorize("hasAuthority('value:delete')")
	public R delete(@RequestBody Long[] ids){
		valueService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
