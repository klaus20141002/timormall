package zhizhu.cy.platform.admin.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import zhizhu.cy.platform.admin.web.util.PageUtils;
import zhizhu.cy.platform.admin.web.util.Query;
import zhizhu.cy.platform.admin.web.util.R;
import zhizhu.cy.platform.admin.web.util.RRException;
import zhizhu.cy.platform.admin.web.util.cloudservice.OSSFactory;
import zhizhu.cy.platform.system.api.entity.SysOss;
import zhizhu.cy.platform.system.api.service.ISysOssService;


/**
 * 文件上传
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-03-25 12:13:26
 */
@RestController
@RequestMapping("sys/oss")
@Api(tags="文件存储服务")
public class SysOssController {
	
	@Autowired
	private ISysOssService sysOssService;

	
	/**
	 * 列表
	 */
	@GetMapping("/list")
//	@RequiresPermissions("sys:oss:all")
	@ApiOperation(value="文件列表")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
		Query query = new Query(params);
		List<SysOss> sysOssList = sysOssService.queryList(query);
		int total = sysOssService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(sysOssList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	

	/**
	 * 上传文件
	 */
	@PostMapping("/upload")
//	@RequiresPermissions("sys:oss:all")
	@ApiOperation(value="上传文件")
	public R upload(@ApiParam(required = true, value = "头像") @RequestParam("file") MultipartFile file) throws Exception {
		if (file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}

		//上传文件
		String url = OSSFactory.build().upload(file.getBytes() , file.getOriginalFilename());

		//保存文件信息
		SysOss ossEntity = new SysOss();
		ossEntity.setUrl(url);
		ossEntity.setCreateTime(new Date());
		sysOssService.save(ossEntity);

		return R.ok().put("url", url);
	}


	/**
	 * 删除
	 */
	@DeleteMapping("/delete")
//	@RequiresPermissions("sys:oss:all")
	@ApiOperation(value="删除文件")
	public R delete(@RequestBody Long[] ids){
		sysOssService.deleteBatch(ids);  

		return R.ok();
	}

}
