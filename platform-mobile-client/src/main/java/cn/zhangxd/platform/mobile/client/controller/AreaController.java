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
import cn.zhangxd.platform.system.api.entity.Area;
import cn.zhangxd.platform.system.api.service.IAreaService;


/**
 * 餐饮-地址-区域选择表
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:53
 */
@RestController
@RequestMapping("/api/{version}/area")
public class AreaController {
	@Autowired
	private IAreaService areaService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('area:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Area> areaList = areaService.queryList(query);
		int total = areaService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(areaList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('area:info')")
	public R info(@PathVariable("id") Long id){
		Area area = areaService.queryObject(id);
		
		return R.ok().put("area", area);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("area:save")
	//@PreAuthorize("hasAuthority('area:save')")
	public R save(@RequestBody Area area){
		areaService.save(area);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("area:update")
	//@PreAuthorize("hasAuthority('area:update')")
	public R update(@RequestBody Area area){
		areaService.update(area);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("area:delete")
	//@PreAuthorize("hasAuthority('area:delete')")
	public R delete(@RequestBody Long[] ids){
		areaService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
