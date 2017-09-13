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
import cn.zhangxd.platform.system.api.entity.OrderComment;
import cn.zhangxd.platform.system.api.service.IOrderCommentService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@RestController
@RequestMapping("/api/{version}/ordercomment")
public class OrderCommentController {
	@Autowired
	private IOrderCommentService orderCommentService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('ordercomment:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<OrderComment> orderCommentList = orderCommentService.queryList(query);
		int total = orderCommentService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(orderCommentList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('ordercomment:info')")
	public R info(@PathVariable("id") Long id){
		OrderComment orderComment = orderCommentService.queryObject(id);
		
		return R.ok().put("orderComment", orderComment);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("ordercomment:save")
	//@PreAuthorize("hasAuthority('ordercomment:save')")
	public R save(@RequestBody OrderComment orderComment){
		orderCommentService.save(orderComment);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("ordercomment:update")
	//@PreAuthorize("hasAuthority('ordercomment:update')")
	public R update(@RequestBody OrderComment orderComment){
		orderCommentService.update(orderComment);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("ordercomment:delete")
	//@PreAuthorize("hasAuthority('ordercomment:delete')")
	public R delete(@RequestBody Long[] ids){
		orderCommentService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
