package cn.zhangxd.platform.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zhangxd.platform.admin.web.common.controller.BaseController;
import cn.zhangxd.platform.admin.web.util.PageUtils;
import cn.zhangxd.platform.admin.web.util.Query;
import cn.zhangxd.platform.admin.web.util.R;
import cn.zhangxd.platform.system.api.entity.Desk;
import cn.zhangxd.platform.system.api.service.IDeskService;


/**
 * 
 * 
 * @author niklaus miakelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-07 16:53:39
 */
@RestController
@RequestMapping("/sys/desk")
@Validated
public class DeskController extends BaseController {
	@Autowired
	private IDeskService deskService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@PreAuthorize("hasAuthority('sys:desk:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Desk> deskList = deskService.queryList(query);
		int total = deskService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(deskList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@PreAuthorize("hasAuthority('sys:desk:info')")
	public R info(@PathVariable("id") Long id){
		Desk desk = deskService.queryObject(id);
		
		return R.ok().put("desk", desk);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@PreAuthorize("hasAuthority('sys:desk:save')")
	public R save(@RequestBody Desk desk){
		deskService.save(desk);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@PreAuthorize("hasAuthority('sys:desk:update')")
	public R update(@RequestBody Desk desk){
		deskService.update(desk);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@PreAuthorize("hasAuthority('sys:desk:delete')")
	public R delete(@RequestBody Long[] ids){
		deskService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
