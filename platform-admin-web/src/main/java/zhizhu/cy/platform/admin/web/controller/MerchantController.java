package zhizhu.cy.platform.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/sys/{version}/merchant")
@Api(tags="商家管理")
public class MerchantController extends BaseController{
	@Autowired
	private IMerchantService merchantService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
//	@PreAuthorize("hasAuthority('sys:merchant:list')")
	@ApiOperation(value = "查看商家列表")
	public R list(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestParam Map<String, Object> params){
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
	@GetMapping("/info/{id}")
//	@PreAuthorize("hasAuthority('sys:merchant:info')")
	@ApiOperation(value = "查看商家信息")
	public R info(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@PathVariable("id") Long id){
		Merchant merchant = merchantService.queryObject(id);
		
		return R.ok().put("merchant", merchant);
	}
	
	/**
	 * 保存
	 */
	@PostMapping("/save")
//	@PreAuthorize("hasAuthority('sys:merchant:save')")
	@ApiOperation(value = "新增商家")
	public R save(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Merchant merchant){
		merchantService.save(merchant);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@PutMapping("/update")
//	@PreAuthorize("hasAuthority('sys:merchant:update')")
	@ApiOperation(value = "更新商家信息")
	public R update(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Merchant merchant){
		merchantService.update(merchant);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
//	@PreAuthorize("hasAuthority('sys:merchant:delete')")
	@ApiOperation(value = "删除商家")
	public R delete(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@RequestBody Long[] ids){
		merchantService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
