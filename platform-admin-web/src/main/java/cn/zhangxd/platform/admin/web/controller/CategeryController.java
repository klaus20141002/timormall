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
import cn.zhangxd.platform.system.api.entity.Categery;
import cn.zhangxd.platform.system.api.service.ICategeryService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:27:32
 */
@RestController
@RequestMapping("categery")
public class CategeryController extends BaseController{
	@Autowired
	private ICategeryService categeryService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@PreAuthorize("hasAuthority('categery:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Categery> categeryList = categeryService.queryList(query);
		int total = categeryService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(categeryList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@PreAuthorize("hasAuthority('categery:info')")
	public R info(@PathVariable("id") Long id){
		Categery categery = categeryService.queryObject(id);
		
		return R.ok().put("categery", categery);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("categery:save")
	@PreAuthorize("hasAuthority('categery:save')")
	public R save(@RequestBody Categery categery){
		categeryService.save(categery);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("categery:update")
	@PreAuthorize("hasAuthority('categery:update')")
	public R update(@RequestBody Categery categery){
		categeryService.update(categery);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("categery:delete")
	@PreAuthorize("hasAuthority('categery:delete')")
	public R delete(@RequestBody Long[] ids){
		categeryService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
