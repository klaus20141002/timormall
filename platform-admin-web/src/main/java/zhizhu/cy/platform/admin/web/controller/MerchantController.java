package zhizhu.cy.platform.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import zhizhu.cy.platform.admin.web.common.controller.BaseController;
import zhizhu.cy.platform.admin.web.util.PageUtils;
import zhizhu.cy.platform.admin.web.util.Query;
import zhizhu.cy.platform.admin.web.util.R;
import zhizhu.cy.platform.system.api.entity.Merchant;
import zhizhu.cy.platform.system.api.service.IMerchantService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 10:39:41
 */
@RestController
@RequestMapping("merchant")
public class MerchantController extends BaseController{
	@Autowired
	private IMerchantService merchantService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@PreAuthorize("hasAuthority('sys:merchant:list')")
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
	@PreAuthorize("hasAuthority('sys:merchant:info')")
	public R info(@PathVariable("id") Long id){
		Merchant merchant = merchantService.queryObject(id);
		
		return R.ok().put("merchant", merchant);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@PreAuthorize("hasAuthority('sys:merchant:save')")
	public R save(@RequestBody Merchant merchant){
		merchantService.save(merchant);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@PreAuthorize("hasAuthority('sys:merchant:update')")
	public R update(@RequestBody Merchant merchant){
		merchantService.update(merchant);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@PreAuthorize("hasAuthority('sys:merchant:delete')")
	public R delete(@RequestBody Long[] ids){
		merchantService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
