package zhizhu.cy.platform.mobile.client.controller;

import java.util.List;
import java.util.Map;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import zhizhu.cy.platform.mobile.client.util.PageUtils;
import zhizhu.cy.platform.mobile.client.util.Query;
import zhizhu.cy.platform.mobile.client.util.R;
import zhizhu.cy.platform.system.api.entity.Food;
import zhizhu.cy.platform.system.api.service.IFoodService;


/**
 * 
 * 
 * @author niklaus mikaelson
 * @email niklausjulie@gmail.com
 * @date 2017-09-12 16:32:37
 */
@RestController
@RequestMapping("/api/{version}/food")
@Api(tags = "菜品")
public class FoodController {
	@Autowired
	private IFoodService foodService;
	
	/**
	 * 列表
	 */
	@GetMapping("/list")
	//@PreAuthorize("hasAuthority('food:list')")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<Food> foodList = foodService.queryList(query);
		int total = foodService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(foodList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	//@PreAuthorize("hasAuthority('food:info')")
	public R info(@PathVariable("id") Long id){
		Food food = foodService.queryObject(id);
		
		return R.ok().put("food", food);
	}
	
	
}
