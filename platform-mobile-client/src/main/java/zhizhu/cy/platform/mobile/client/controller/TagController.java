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
import zhizhu.cy.platform.system.api.entity.Tag;
import zhizhu.cy.platform.system.api.service.ITagService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@RestController
@RequestMapping("/api/{version}/tag")
public class TagController {
	@Autowired
	private ITagService tagService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('tag:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Tag> tagList = tagService.queryList(query);
		int total = tagService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(tagList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('tag:info')")
	public R info(@PathVariable("id") Long id){
		Tag tag = tagService.queryObject(id);
		
		return R.ok().put("tag", tag);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("tag:save")
	//@PreAuthorize("hasAuthority('tag:save')")
	public R save(@RequestBody Tag tag){
		tagService.save(tag);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("tag:update")
	//@PreAuthorize("hasAuthority('tag:update')")
	public R update(@RequestBody Tag tag){
		tagService.update(tag);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("tag:delete")
	//@PreAuthorize("hasAuthority('tag:delete')")
	public R delete(@RequestBody Long[] ids){
		tagService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
