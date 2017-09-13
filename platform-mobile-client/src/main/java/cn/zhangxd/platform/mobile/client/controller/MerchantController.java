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
import cn.zhangxd.platform.system.api.entity.Merchant;
import cn.zhangxd.platform.system.api.service.IMerchantService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@RestController
@RequestMapping("/api/{version}/merchant")
public class MerchantController {
	@Autowired
	private IMerchantService merchantService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	//@PreAuthorize("hasAuthority('merchant:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Merchant> merchantList = merchantService.queryList(query);
		int total = merchantService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(merchantList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('merchant:info')")
	public R info(@PathVariable("id") Long id){
		Merchant merchant = merchantService.queryObject(id);
		
		return R.ok().put("merchant", merchant);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	//@RequiresPermissions("merchant:save")
	//@PreAuthorize("hasAuthority('merchant:save')")
	public R save(@RequestBody Merchant merchant){
		merchantService.save(merchant);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	//@RequiresPermissions("merchant:update")
	//@PreAuthorize("hasAuthority('merchant:update')")
	public R update(@RequestBody Merchant merchant){
		merchantService.update(merchant);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	//@RequiresPermissions("merchant:delete")
	//@PreAuthorize("hasAuthority('merchant:delete')")
	public R delete(@RequestBody Long[] ids){
		merchantService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
