/******************************************************************************
 * @File name   :      GoodsController.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月28日
 *
 * @Copyright Notice: 
 * Copyright (c) 2017 TimorJun, Inc. All  Rights Reserved.
 * This software is published under the terms of TimorJun
 * License version 1.0, a copy of which has been included with this
 * distribution in the LICENSE.txt file.
 * 
 * 
 * ----------------------------------------------------------------------------
 * Date                   Who         Version        Comments
 * 2017年9月28日 上午12:00:16        niklaus     1.0            Initial Version
 *****************************************************************************/
package com.klauting.timormall.admin.web.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klauting.timormall.admin.web.constant.CommonConstant;
import com.klauting.timormall.admin.web.util.R;
import com.klauting.timormall.system.api.entity.GoodsAd;
import com.klauting.timormall.system.api.entity.GoodsBasic;
import com.klauting.timormall.system.api.entity.GoodsExt;
import com.klauting.timormall.system.api.entity.GoodsUrl;
import com.klauting.timormall.system.api.service.IGoodsAdService;
import com.klauting.timormall.system.api.service.IGoodsBasicService;
import com.klauting.timormall.system.api.service.IGoodsExtService;
import com.klauting.timormall.system.api.service.IGoodsUrlService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 *
 */
@RestController
@Api(tags="商品管理")
@RequestMapping("/sys/{version}/goods")
public class GoodsController {

	@Value(value = "${taobao.file.path}")
	private String goodsFilePath;
	
	@Autowired
	private IGoodsBasicService goodsBasicService;
	
	@Autowired
	private IGoodsUrlService goodsUrlService;
	
	@Autowired
	private IGoodsExtService goodsExtService;
	
	@Autowired
	private IGoodsAdService goodsAdService;
	
	
	private static final Logger logger = LoggerFactory.getLogger( GoodsController.class );
	
	/**
	 * @Date        :      2017年9月24日
	 * @param version
	 * @param filename
	 * @param adName
	 * @return
	 */
	@GetMapping("/taobao/dailychoose")
	@ApiOperation(value="导入每日优选商品")
	public R importTaobaoDailyGoodsByFilepath(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "文件名称", defaultValue = "") @RequestParam(name="filename",required=true)String filename,
			@ApiParam(required = false, value = "广告位名称") @RequestParam(name="adName",required=false)String adName) {
		String msg = "SUCCESS";
		HSSFWorkbook book = null;
		try {
			logger.info("start handle filename {}",CommonConstant.GOODS_TAOBAO_FILEPATH+filename);
			book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(goodsFilePath+filename)));
			GoodsAd ad= goodsAdService.queryByAdName(adName);
			
			HSSFSheet sheet = book.getSheetAt(0);
			for(int i=1; i<sheet.getLastRowNum()+1; i++) {
			    HSSFRow row = sheet.getRow(i);
			    String num_iid = row.getCell(0).getStringCellValue();//商品ID
			    String title = row.getCell(1).getStringCellValue(); //商品名称
			    String pict_url = row.getCell(2).getStringCellValue();//商品主图
			    String item_url = row.getCell(3).getStringCellValue();//商品详情页
			    String shop_category = row.getCell(4).getStringCellValue(); //商品一级类目
			    String click_url = row.getCell(5).getStringCellValue(); //淘宝客链接
			    if(click_url!=null&&click_url.length()>2000) {
			    	continue;
			    }
			    String zk_final_price = row.getCell(6).getStringCellValue();//商品价格(单位：元)
			    String volume = row.getCell(7).getStringCellValue();//商品月销量
			    String tk_rate = row.getCell(8).getStringCellValue();//收入比率(%)
			    String tk_money = row.getCell(9).getStringCellValue();//佣金
			    String seller_wanwan = row.getCell(10).getStringCellValue();//卖家旺旺
			    String seller_id = row.getCell(11).getStringCellValue();//卖家id
			    String shop_title = row.getCell(12).getStringCellValue();//店铺名称
			    String platform_type = row.getCell(13).getStringCellValue();//平台类型
			    String coupon_id = row.getCell(14).getStringCellValue();//优惠券id
			    String coupon_total_count = row.getCell(15).getStringCellValue();//优惠券总量
			    String coupon_remain_count = row.getCell(16).getStringCellValue();//优惠券剩余量
			    String coupon_info = row.getCell(17).getStringCellValue();//优惠券面额
			    String coupon_start_time = row.getCell(18)!=null?row.getCell(18).getStringCellValue():null;//优惠券开始时间
			    String coupon_end_time = row.getCell(19)!=null?row.getCell(19).getStringCellValue():null;//优惠券结束时间
			    String coupon_url = row.getCell(20)!=null?row.getCell(20).getStringCellValue():null;//优惠券链接
			    String coupon_click_url = row.getCell(21)!=null?row.getCell(21).getStringCellValue():null;//优惠券链接
			    if("天猫".equals(platform_type)) {
			    	platform_type= "1";
			    }else if("淘宝".equals(platform_type)) {
			    	platform_type= "2";
			    }
			    
			    GoodsBasic goodsBasic = new GoodsBasic();
				GoodsUrl goodsUrl = new GoodsUrl();
				GoodsExt goodsExt = new GoodsExt();
				GoodsAd goodsAd =  new GoodsAd();
				goodsBasic.setCreateTime(new Date());
				goodsBasic.setUpdateTime(new Date());
				goodsBasic.setDataStatus(1);
				goodsBasic.setGoodsId(Long.parseLong(num_iid));//商品ID
				goodsBasic.setPlatformId(Integer.parseInt(platform_type));//平台类型
				goodsBasic.setCategory(shop_category); //商品一级类目
				goodsBasic.setGoodsTitle(title);//商品名称
				goodsBasic.setGoodsImg(pict_url);//商品主图
				goodsBasic.setItemUrl(item_url);//商品详情页
				goodsBasic.setVolume(Integer.parseInt(volume));//商品月销量
				goodsBasic.setGoodsPrice(new BigDecimal(zk_final_price));//商品价格(单位：元)
				goodsUrl.setCreateTime(new Date());
				goodsUrl.setUpdateTime(new Date());
				goodsUrl.setDataStatus(1);
				goodsUrl.setPlatformId(Integer.parseInt(platform_type));
				goodsUrl.setGoodsId(Long.parseLong(num_iid));
				goodsUrl.setClickUrl(click_url);//淘宝客链接
				goodsUrl.setCouponInfo(coupon_info);//优惠券面额
				goodsUrl.setCouponUrl(coupon_url);//优惠券链接
				goodsUrl.setCouponClickUrl(coupon_click_url);//优惠券链接
				goodsUrl.setCouponTotalCount(Integer.parseInt(coupon_total_count));//优惠券总量
				goodsUrl.setCouponRemainCount(Integer.parseInt(coupon_remain_count));//优惠券剩余量
				if(!StringUtils.isEmpty(coupon_start_time)) {
					goodsUrl.setCouponStartTime(DateUtils.parseDate(coupon_start_time, CommonConstant.RFC822_DATE_FORMAT_SHORT));//优惠券开始时间
				}
				if(!StringUtils.isEmpty(coupon_end_time)) {
					goodsUrl.setCouponEndTime(DateUtils.parseDate(coupon_end_time, CommonConstant.RFC822_DATE_FORMAT_SHORT));//优惠券结束时间
				}
				goodsExt.setCreateTime(new Date());
				goodsExt.setUpdateTime(new Date());
				goodsExt.setDataStatus(1);
				goodsExt.setGoodsId(Long.parseLong(num_iid));
				goodsExt.setPlatformId(Integer.parseInt(platform_type));
				goodsExt.setTkMoney(new BigDecimal(tk_money));//佣金
				goodsExt.setTkRate(new BigDecimal(tk_rate));//收入比率(%)
				goodsExt.setSellerWanwan(seller_wanwan);//卖家旺旺
				goodsExt.setSellerId(Long.parseLong(seller_id));//卖家id
				goodsExt.setShopTitle(shop_title);//店铺名称
				goodsAd.setCreateTime(new Date());
				goodsAd.setUpdateTime(new Date());
				goodsAd.setDataStatus(1);
				goodsAd.setAdName(ad == null ? CommonConstant.GOODS_AD_DEFAULT:adName);//广告位
			    goodsAd.setPlatformId(Integer.parseInt(platform_type));
			    goodsAd.setGoodsId(Long.parseLong(num_iid));
			    if( Long.parseLong(num_iid)==555602212739L) {
			    	System.out.println("1312312");
			    }
			    if(goodsBasicService.queryGoodsIdAndPlatformId(Long.parseLong(num_iid), Integer.parseInt(platform_type)) == null) {
				    goodsBasicService.save(goodsBasic);
				    goodsUrlService.save(goodsUrl);
				    goodsAdService.save(goodsAd);
				    goodsExtService.save(goodsExt);
			    } else {
			    	goodsBasicService.update(goodsBasic);
			    }
			}

			logger.info("共有 " + sheet.getLastRowNum() + " 条数据：");
			
			
		} catch (FileNotFoundException e) {
			logger.error("导入Excel FileNotFoundException {}",e);
			msg = "参数错误，文件路径找不到或文件格式错误，只支持xls";
		} catch (IOException e) {
			logger.error("导入Excel IOException {}",e);
			msg = "文件处理出错";
		} catch (Exception e) {
			logger.error("导入Excel IOException {}",e);
			msg = "发生错误";
		} finally {
			try {
				if(book!= null) {
					book.close();
				}
			} catch (IOException e) {
				logger.error("close book {}",e);
			}
		}
		return R.ok(msg);
	}
	
	
	/**
	 * @Date        :      2017年7月11日
	 * 导入选品库数据 高佣活动
	 * @param filename
	 * @return
	 */
	@GetMapping("/taobao/favorite/highevent")
	@ApiOperation(value="导入选品库高佣商品")
	public R importTaobaoFavoriteByFilepath(
			@ApiParam(required = true, value = "版本", defaultValue = "v1") @PathVariable("version") String version,
			@ApiParam(required = true, value = "文件名称", defaultValue = "") @RequestParam(name="filename",required=true)String filename,
			@ApiParam(required = false, value = "广告位名称") @RequestParam(name="adName",required=false)String adName
			) {
		String msg = "";
		// create a new file
		HSSFWorkbook book = null;
		try {

			book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile(goodsFilePath+filename)));

			HSSFSheet sheet = book.getSheetAt(0);
			GoodsAd ad= goodsAdService.queryByAdName(adName);
			for(int i=1; i<sheet.getLastRowNum()+1; i++) {
			    HSSFRow row = sheet.getRow(i);
			    String num_iid = row.getCell(0)==null?null:row.getCell(0).getStringCellValue();//商品ID
			    String title = row.getCell(1)==null?null:row.getCell(1).getStringCellValue(); //商品名称
			    String pict_url = row.getCell(2)==null?null:row.getCell(2).getStringCellValue();//商品主图
			    String item_url = row.getCell(3)==null?null:row.getCell(3).getStringCellValue();//商品详情页
			    String shop_title = row.getCell(4)==null?null:row.getCell(4).getStringCellValue(); //店铺名称
			    String price = row.getCell(5)==null?null:row.getCell(5).getStringCellValue();//商品价格
			    String volume = row.getCell(6)==null?null:row.getCell(6).getStringCellValue();//商品月销量
			    String tk_rate_normal = row.getCell(7)==null?null:row.getCell(7).getStringCellValue();//通用收入比率(%)
			    String tk_money_normal = row.getCell(8)==null?null:row.getCell(8).getStringCellValue();//通用佣金
			    String event_state = row.getCell(9)==null?null:row.getCell(9).getStringCellValue();//活动状态
			    String tk_rate =row.getCell(10)==null?null: row.getCell(10).getStringCellValue();//活动收入比率
			    String tk_money = row.getCell(11)==null?null:row.getCell(11).getStringCellValue();//活动佣金
			    String event_start_time = row.getCell(12)==null?null:row.getCell(12).getStringCellValue();//活动开始时间
			    String event_end_time = row.getCell(13)==null?null:row.getCell(13).getStringCellValue();//活动结束时间
			    String saller_wangwang = row.getCell(14)==null?null:row.getCell(14).getStringCellValue();//卖家旺旺
			    String click_url_short = row.getCell(15)==null?null:row.getCell(15).getStringCellValue();//淘宝客短链接
			    String click_url = row.getCell(16)==null?null:row.getCell(16).getStringCellValue();//淘宝客链接
			    String click_taokouling = row.getCell(17)==null?null:row.getCell(17).getStringCellValue();//淘口令
			    String coupon_total_count = row.getCell(18)==null?null:row.getCell(18).getStringCellValue();//优惠券总量
			    String coupon_remain_count = row.getCell(19)==null?null:row.getCell(19).getStringCellValue();//优惠券剩余量
			    String coupon_info = row.getCell(20)==null?null:row.getCell(20).getStringCellValue();//优惠券面额
			    String coupon_start_time = row.getCell(21)!=null?row.getCell(21).getStringCellValue():null;//优惠券开始时间
			    String coupon_end_time = row.getCell(22)!=null?row.getCell(22).getStringCellValue():null;//优惠券结束时间
			    String coupon_click_url = row.getCell(23)!=null?row.getCell(23).getStringCellValue():null;//优惠券链接
			    String coupon_click_taokouling = row.getCell(24)!=null?row.getCell(24).getStringCellValue():null;//优惠券淘口令
			    String coupon_click_short_url = row.getCell(25)!=null?row.getCell(25).getStringCellValue():null;//优惠券短链接
			    GoodsBasic goodsBasic = new GoodsBasic();
				GoodsUrl goodsUrl = new GoodsUrl();
				GoodsExt goodsExt = new GoodsExt();
				GoodsAd goodsAd =  new GoodsAd();
				goodsBasic.setCreateTime(new Date());
				goodsBasic.setUpdateTime(new Date());
				goodsBasic.setDataStatus(1);
				goodsBasic.setGoodsId(Long.parseLong(num_iid));//商品ID
				goodsBasic.setPlatformId(1);
//				goodsBasic.setCategory(category);
				goodsBasic.setGoodsTitle(title);//商品名称
				goodsBasic.setGoodsImg(pict_url);//商品主图
				goodsBasic.setItemUrl(item_url);//商品详情页
				goodsBasic.setVolume(Integer.parseInt(volume));//商品月销量
				goodsBasic.setGoodsPrice(new BigDecimal(price));
				goodsUrl.setCreateTime(new Date());
				goodsUrl.setUpdateTime(new Date());
				goodsUrl.setAdName(ad == null ? CommonConstant.GOODS_AD_DEFAULT:adName);
				goodsUrl.setDataStatus(1);
				goodsUrl.setPlatformId(1);
				goodsUrl.setGoodsId(Long.parseLong(num_iid));
				goodsUrl.setClickUrl(click_url);//淘宝客短链接  //淘宝客链接
				goodsUrl.setClickTaokouling(click_taokouling);//淘口令
				goodsUrl.setCouponInfo(coupon_info);//优惠券面额
				goodsUrl.setCouponUrl(coupon_click_url);//优惠券链接
				goodsUrl.setCouponTaokouling(coupon_click_taokouling);//优惠券淘口令
				goodsUrl.setCouponClickUrl(coupon_click_short_url);//优惠券短链接
				goodsUrl.setCouponTotalCount(Integer.parseInt(coupon_total_count));//优惠券总量
				goodsUrl.setCouponRemainCount(Integer.parseInt(coupon_remain_count));//优惠券剩余量
				if(!StringUtils.isEmpty(coupon_start_time)) {
					goodsUrl.setCouponStartTime(DateUtils.parseDate(coupon_start_time, CommonConstant.RFC822_DATE_FORMAT_SHORT));//优惠券开始时间
				}
				if(!StringUtils.isEmpty(coupon_end_time)) {
					goodsUrl.setCouponEndTime(DateUtils.parseDate(coupon_end_time, CommonConstant.RFC822_DATE_FORMAT_SHORT));//优惠券结束时间
				}
				goodsExt.setCreateTime(new Date());
				goodsExt.setUpdateTime(new Date());
				goodsExt.setDataStatus(1);
				goodsExt.setGoodsId(Long.parseLong(num_iid));
				goodsExt.setPlatformId(1);
				goodsExt.setTkMoney(new BigDecimal(tk_money_normal));//活动收入比率
				goodsExt.setTkRate(new BigDecimal(tk_rate_normal));//活动佣金
				goodsExt.setSellerWanwan(saller_wangwang);//卖家旺旺
//				goodsExt.setSellerId(Integer.parseInt(seller_id));
				goodsExt.setShopTitle(shop_title);//店铺名称
				goodsAd.setCreateTime(new Date());
				goodsAd.setUpdateTime(new Date());
				goodsAd.setDataStatus(1);
				goodsAd.setAdName(ad == null ? CommonConstant.GOODS_AD_DEFAULT:adName);//广告位
			    goodsAd.setPlatformId(1);
			    goodsAd.setGoodsId(Long.parseLong(num_iid));
			    
			    if(goodsBasicService.queryGoodsIdAndPlatformId(Long.parseLong(num_iid), 1) == null) {
				    goodsBasicService.save(goodsBasic);
				    goodsUrlService.save(goodsUrl);
				    goodsAdService.save(goodsAd);
				    goodsExtService.save(goodsExt);
			    }
			}

			logger.info("共有 " +sheet.getLastRowNum() + " 条数据：");
			
			
		} catch (FileNotFoundException e) {
			logger.error("导入Excel FileNotFoundException {}",e);
			msg = "参数错误，文件路径找不到或文件格式错误，只支持xls";
		} catch (IOException e) {
			logger.error("导入Excel IOException {}",e);
			msg = "文件处理出错";
		} catch (Exception e) {
			logger.error("导入Excel IOException {}",e);
			msg = "发生错误";
		} finally {
			try {
				book.close();
			} catch (IOException e) {
				logger.error("close book {}",e);
			}
		}
		
		
		return R.ok(msg);
		
		
		
	}


	public String getGoodsFilePath() {
		return goodsFilePath;
	}


	public void setGoodsFilePath(String goodsFilePath) {
		this.goodsFilePath = goodsFilePath;
	}
	

	


}
