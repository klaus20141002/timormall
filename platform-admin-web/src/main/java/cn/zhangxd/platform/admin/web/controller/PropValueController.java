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
import cn.zhangxd.platform.system.api.entity.PropValue;
import cn.zhangxd.platform.system.api.service.IPropValueService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:48
 */
@RestController
@RequestMapping("propvalue")
public class PropValueController extends BaseController{
	@Autowired
	private IPropValueService propValueService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@PreAuthorize("hasAuthority('propvalue:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<PropValue> propValueList = propValueService.queryList(query);
		int total = propValueService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(propValueList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@PreAuthorize("hasAuthority('propvalue:info')")
	public R info(@PathVariable("id") Long id){
		PropValue propValue = propValueService.queryObject(id);
		
		return R.ok().put("propValue", propValue);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("propvalue:save")
	@PreAuthorize("hasAuthority('propvalue:save')")
	public R save(@RequestBody PropValue propValue){
		propValueService.save(propValue);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("propvalue:update")
	@PreAuthorize("hasAuthority('propvalue:update')")
	public R update(@RequestBody PropValue propValue){
		propValueService.update(propValue);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("propvalue:delete")
	@PreAuthorize("hasAuthority('propvalue:delete')")
	public R delete(@RequestBody Long[] ids){
		propValueService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
