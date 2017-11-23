package com.klauting.timormall.system.provider.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.klauting.timormall.system.api.constant.GoodsSpiderConst;
import com.klauting.timormall.system.api.dto.spider.DescInfo;
import com.klauting.timormall.system.api.dto.spider.DetailImagesDescDto;
import com.klauting.timormall.system.api.dto.spider.DetailImagesDto;
import com.klauting.timormall.system.api.dto.spider.GoodsSpiderDto;
import com.klauting.timormall.system.api.dto.spider.GoodsSpiderInfoDto;
import com.klauting.timormall.system.api.dto.spider.ItemInfoModel;
import com.klauting.timormall.system.api.service.ISpiderService;
import com.klauting.timormall.system.provider.util.DownPageUtil;
import com.klauting.timormall.system.provider.util.SymbolUtils;

import us.codecraft.webmagic.selector.Json;

@Service
public class SpiderServiceImpl implements ISpiderService {
	private static final Logger logger = LoggerFactory.getLogger(SpiderServiceImpl.class);
	
	@Value("${spider.url.taobao}")
	private String taobaoUrl ;
	
//	#taobao/tmall detail imgs pattern   exclude .gif
//	taobao_tmall_detail_imgs_pattern=(//|https://|http://)img.alicdn.com/imgextra.*?\\.(jpg|png|jpeg|bmp|gif)
//
//	#jd_detail_imgs_pattern
//	jd_detail_imgs_pattern= //img[\\.\\w\\d/_]+\\.(jpg|png|jpeg|bmp)
	
	@Value("${spider.pattern.taobaoTmallDetailImgs}")
	private String taobaoTmallDetailImgs ;
	@Value("${spider.pattern.jdDetailImgs}")
	private String jdDetailImgs ;
	

	
	
	
	
	
	@Override
	public Map<String, Object> getGoodsDetailSimple(String goodsId, String platformId) {
		
		String goodsUrl = taobaoUrl.replaceFirst("GOODSID", goodsId) ;
		logger.info("object url is : {}",goodsUrl);
		
		Map<String,Object> respResultMap = new HashMap<String,Object>();
		String res = DownPageUtil.downloadPage(goodsUrl);
		Gson gson = new Gson();  
		GoodsSpiderDto goodsSpiderDto = gson.fromJson(res, GoodsSpiderDto.class);
		if(goodsSpiderDto==null) {
			logger.error("异常 ! Json为空,商品url={}", goodsUrl);
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", "爬取商品spu信息出现异常,请稍后再试或直接联系相关人员");
			return respResultMap;
		}
		if(goodsSpiderDto!=null && goodsSpiderDto.getRet().get(0).contains("checkcode")) {
			logger.error("异常 ! Json为空,商品url={}", goodsUrl);
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", goodsSpiderDto.getRet().get(0));
			return respResultMap;
		}
		if(goodsSpiderDto!=null && goodsSpiderDto.getRet().get(0).contains("ERRCODE")) {
			logger.error("异常 ! Json为空,商品url={}", goodsUrl);
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", goodsSpiderDto.getRet().get(0));
			return respResultMap;
		}
		if(goodsSpiderDto!=null && goodsSpiderDto.getRet().get(0).contains("SUCCESS")) {
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.OK);
			GoodsSpiderInfoDto goodsSpiderInfo = goodsSpiderDto.getData();
			ItemInfoModel itemInfoModel = goodsSpiderInfo.getItemInfoModel();
			respResultMap.put("goodsThumbnailImgs", itemInfoModel.getPicsPath());
			DescInfo descInfo = goodsSpiderInfo.getDescInfo();
			String goodsDetailImgesUrl = descInfo.getFullDescUrl();
			
			String detailImages = DownPageUtil.downloadPage(goodsDetailImgesUrl);
			DetailImagesDto detailImagesDto = gson.fromJson(detailImages, DetailImagesDto.class);
			if(detailImagesDto!=null && detailImagesDto.getRet().get(0).contains("SUCCESS")) {
				DetailImagesDescDto detailImagesDescDto = detailImagesDto.getData();
				String desc = detailImagesDescDto.getDesc();
				respResultMap.put("DetailImgs", getDetailImgslist(desc));
			} else {
				logger.error("异常 ! Json为空,商品url={}", goodsUrl);
				respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
				respResultMap.put("msg", "爬取商品goods detail images 出现异常,请稍后再试或直接联系相关人员");
				return respResultMap;
				
			}
		}
		logger.info("respResultMap : {} ",respResultMap);
		return respResultMap;
	}

	/* (non-Javadoc)
	 * @see com.klauting.timormall.system.api.service.ISpiderService#getGoodsDetail()
	 */
	@Override
	public Map<String,Object> getGoodsDetail(String goodsId, String platformId) {
		String goodsUrl = taobaoUrl.replaceFirst("GOODSID", goodsId) ;
		
		// TODO Auto-generated method stub
		Map<String,Object> respResultMap = new HashMap<String,Object>();
		logger.info("object url is : {}",goodsUrl);
		String res = DownPageUtil.downloadPage(goodsUrl);
		Gson gson = new Gson();  
		GoodsSpiderDto goodsSpiderDto = gson.fromJson(res, GoodsSpiderDto.class);
		
		Json json = new Json(res);
		if (json == null) {
			logger.error("异常 ! Json为空,商品url={}", goodsUrl);
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", "爬取商品spu信息出现异常,请稍后再试或直接联系相关人员");
			return respResultMap;
		}

		String value = json.jsonPath("$..ret").get();
		if (value.contains("checkcode")) {
			logger.error(" 访问受限 ,商品url={}", goodsUrl);
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", "爬取商品spu信息-访问受限,请稍后再试或直接联系相关人员");
			return respResultMap;
		}
		
		// 商品下架逻辑处理
		String saleOff = null;
		boolean saleOffFlag = false;
		saleOff = json.jsonPath("$..ret").get();
		if (saleOff.contains("宝贝不存在")) {
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", "宝贝不存在");
			return respResultMap;

		}
		Json apiStackValueJson = null;
		String apiStackStr = json.jsonPath("$..data.apiStack.value").get();
		if (!StringUtils.isEmpty(apiStackStr)) {
			apiStackValueJson = new Json(apiStackStr);

			String errorMessage = null; // 下架原因
			errorMessage = apiStackValueJson.jsonPath("$..data.itemControl.unitControl.errorMessage").get();
			// 如果unitControl的值出现errorMessage，且包含 已下架 区域卖光，则商品也下架了
			if (!StringUtils.isEmpty(errorMessage)) {
				if (errorMessage.contains("已下架") || errorMessage.contains("区域卖光")) {
					respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
					respResultMap.put("msg", "宝贝不存在");
					return respResultMap;
				}
			}
			//库存
			String quantity = apiStackValueJson.jsonPath("$..itemInfoModel.quantity").get().trim();

		} else {
			logger.error(" 异常！ 淘宝 天猫 Api获取失败 , 得不到$..data.apiStack.value信息,商品url={}", goodsUrl);
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", "爬取商品spu信息出现异常,得不到apiStack信息");
			return respResultMap;
		}
		
		
		// 获取原价和促销价
		List<String> price = apiStackValueJson.jsonPath("$..itemInfoModel.priceUnits.price").all();
		if (price != null && !price.isEmpty()) {
			// 有原价，又有促销价的情况,原价就放划掉的价格，取高的
			if (price.size() > 1) {
				// 促销价解析
				String price0 = price.get(0);
				if (price0.startsWith("-")) {
					price0 = price0.substring(1);
				}
				if (price0.split(SymbolUtils.LINE).length > 1) { // 促销价是个价格区间
//							qualityGoods.setPromotionPrice(Float.parseFloat(price0.split(SymbolUtils.LINE)[0])); // 取低的
				} else {
//							qualityGoods.setPromotionPrice(Float.parseFloat(price0.split(SymbolUtils.LINE)[0]));
				}
				
				// 原价解析
				String price1 = price.get(1);
				if (price1.startsWith("-")) {
					price1 = price1.substring(1);
				}
				if (price1.split(SymbolUtils.LINE).length > 1) { // 原价是个价格区间
//							qualityGoods.setPrice(Float.parseFloat(price1.split(SymbolUtils.LINE)[1])); // 取高的
				} else {
//							qualityGoods.setPrice(Float.parseFloat(price1.split(SymbolUtils.LINE)[0]));
				}
			} else {
				// 只有原价的情况，拿低的价格
				String price0 = price.get(0);
				if (price0.startsWith("-")) {
					price0 = price0.substring(1);
				}
				if (price0.split(SymbolUtils.LINE).length > 1) { // 原价是个价格区间
//							qualityGoods.setPrice(Float.parseFloat(price0.split(SymbolUtils.LINE)[1])); // 原价拿高的
					// 此时要把原价中的下限冗余到促销价,默认促销价为商品单买销售价格
//							qualityGoods.setPromotionPrice(Float.parseFloat(price0.split(SymbolUtils.LINE)[0]));
				} else {
					// 此时要把原价冗余到促销价,默认促销价为商品销售价格
//							qualityGoods.setPrice(Float.parseFloat(price0.split(SymbolUtils.LINE)[0]));
//							qualityGoods.setPromotionPrice(Float.parseFloat(price0.split(SymbolUtils.LINE)[0]));
				}
			}
		} else {
			logger.error(" 异常！ 淘宝 天猫 Api获取失败  找不到商品价格   商品url={}", goodsUrl);
			respResultMap.put("status", GoodsSpiderConst.TaskStatus.FAILED);
			respResultMap.put("msg", "爬取商品spu信息出现异常, 找不到商品价格");
			return respResultMap;
		}
				
		//获取邮费信息
		float deliveryFees = 0;
		String deliveryInfo = apiStackValueJson.jsonPath("$..data.delivery.deliveryFees").get();
		/*
		 * 返回的信息格式： 快递 12.00   卖家包邮    快递 免运费
		 */
		if(! StringUtils.isEmpty(deliveryInfo)){
			deliveryInfo = deliveryInfo.trim();
			if( deliveryInfo.contains("包邮")  || deliveryInfo.contains("免运费") ){
				deliveryFees = 0;
			}
			if( deliveryInfo.contains("快递") ){
				//用空格分隔
				String[] array = deliveryInfo.split(" ");
				//默认处理格式：快递 12.00
				if( null != array && array.length > 1 ){
					if(! StringUtils.isEmpty(array[1])){
						try {
							deliveryFees = Float.parseFloat(array[1].trim());
						} catch (NumberFormatException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
//		qualityGoods.setDeliveryFees(deliveryFees);
		
		
		// 得到商品图片信息
		List<String> imgUrlList = json.jsonPath("$..data.itemInfoModel.picsPath").all();
		StringBuffer imgs = new StringBuffer();
		if (null != imgUrlList && imgUrlList.size() > 0) {
			for (String img : imgUrlList) {
				imgs.append(img).append("&");
			}
//			qualityGoods.setSpiderThumbnailImgs(imgs.toString()); // 添加商品缩略图图片
		} else {
			logger.error("爬取商品图片出现错误! 商品url={}", goodsUrl);
		}
		
		//得到商品名
		String goodsTitle = json.jsonPath("$..data.itemInfoModel.title").get().trim();
//		qualityGoods.setTitle(goodsTitle);
		
		//得到一个商品是否含有sku 
		String isContainSku = json.jsonPath("$..data.itemInfoModel.sku").get().trim();

		// 根据是否含有sku来进行下面sku的逻辑
		if (isContainSku.equals("false")) {
//			qualityGoods.setIsContainSku(Const.IsContainSku.NOT_CONTAIN_SKU);
			logger.info("这个商品只有spu信息,没有sku信息,商品url={}", goodsUrl);
//			spuInfo = new SpuInfo();
//			spuInfo.setQualityGoods(qualityGoods);
//
//			respResultMap.put("status", Const.TaskStatus.OK);
//			respResultMap.put("spuInfo", spuInfo);
//			return respResultMap;
		}

		// 商品有sku的情况
//		qualityGoods.setIsContainSku(Const.IsContainSku.CONTAIN_SKU);

		
		return respResultMap;
		
		
	}


	public String getTaobaoUrl() {
		return taobaoUrl;
	}


	public void setTaobaoUrl(String taobaoUrl) {
		this.taobaoUrl = taobaoUrl;
	}



	
	private List<String> getDetailImgslist( String detailImgsContent ){
		List<String> imgsList = new ArrayList<>();
		
		//https://img.alicdn.com/imgextra.*?\\.(jpg|png|jpeg|bmp|gif)  不需要gif图片
		//要加上gif,先拿过来,然后下面在过滤,不然会出现下面的情况,最小匹配
		// https://img.alicdn.com/imgextra***38567924.gif"> <img align="absmiddle" src="https://img.alicdn.com/imgextra/i2/*****8567924.jpg
		//最开始的值：   taobaoTmallDetailImgs: (//|https://|http://)img.alicdn.com/imgextra.*?\\.(jpg|png|jpeg|bmp|gif)
		//修改后:taobaoTmallDetailImgs=(//|https://|http://)img.alicdn.com/imgextra.*?\\.(jpg|png|jpeg|bmp|gif)
		
		logger.info("taobao_imgs_pattern {}",taobaoTmallDetailImgs);
		logger.info("detailImgsContent {}",detailImgsContent);
//		Matcher  m = Pattern.compile(taobaoTmallDetailImgs).matcher( detailImgsContent );
		Matcher  m = Pattern.compile("(//|https://|http://)img.alicdn.com/imgextra.*?\\.(jpg|png|jpeg|bmp|gif)").matcher( detailImgsContent );
		//http://img.alicdn.com/imgextra/i2/2289469223/TB26QCquAqvpuFjSZFhXXaOgXXa_!!2289469223.jpg
		while( m.find() ){
			String img  = m.group();
			//把gif动图排除掉
			if(! img.contains(".gif") ){
				//对于//img.alicdn.com/imgextra/i4/165942227/T2lIVgXhBMXXXXXXXX_!!165942227.jpg类型的图片,加上https:
				if( img.contains("http")){
					imgsList.add( img );
				}else{
					imgsList.add("https:"+img);
				}
				
			}
				
		}
		return imgsList;
	}
	
	public static void main(String[] args) {
		String init = "<html>\n <head>\n  <script>window.TBDetail = (window.TBDetail || {});\nwindow.TBDetail.data = {itemId:42347685966,sellerId:2289469223}</script>\n </head>\n <body>\n  <img class=\"desc_anchor\" id=\"desc-module-1\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <p><img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i2/2289469223/TB26QCquAqvpuFjSZFhXXaOgXXa_!!2289469223.jpg\" /><img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i1/2289469223/TB2sgiyhPuhSKJjSspaXXXFgFXa_!!2289469223.jpg\" /></p>\n  <img class=\"desc_anchor\" id=\"desc-module-2\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <p><img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i1/2289469223/TB2cYswq9XlpuFjy0FeXXcJbFXa_!!2289469223.jpg\" /><img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i2/2289469223/TB2uJJ.uxtmpuFjSZFqXXbHFpXa_!!2289469223.jpg\" /></p>\n  <img class=\"desc_anchor\" id=\"desc-module-3\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i1/2289469223/TB2OFZJq4dkpuFjy0FbXXaNnpXa_!!2289469223.jpg\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i2/2289469223/TB2qXO0utFopuFjSZFHXXbSlXXa_!!2289469223.jpg\" />\n  <img class=\"desc_anchor\" id=\"desc-module-4\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i4/2289469223/TB2LRZbc6ihSKJjy0FfXXbGzFXa_!!2289469223.jpg\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i2/2289469223/TB2YNxlcvBNTKJjSszcXXbO2VXa_!!2289469223.jpg\" />\n  <img class=\"desc_anchor\" id=\"desc-module-5\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i3/2289469223/TB2IuKQy7qvpuFjSZFhXXaOgXXa_!!2289469223.jpg\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i3/2289469223/TB28VaFrgxlpuFjy0FoXXa.lXXa_!!2289469223.jpg\" />\n  <img class=\"desc_anchor\" id=\"desc-module-6\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i1/2289469223/TB27p4krbJkpuFjy1zcXXa5FFXa_!!2289469223.jpg\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i1/2289469223/TB2x.0urbXlpuFjy1zbXXb_qpXa_!!2289469223.jpg\" />\n  <img class=\"desc_anchor\" id=\"desc-module-7\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i3/2289469223/TB28T8QrbFkpuFjy1XcXXclapXa_!!2289469223.jpg\" />\n  <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i3/2289469223/TB2zbYUji0TMKJjSZFNXXa_1FXa_!!2289469223.jpg\" />\n  <img class=\"desc_anchor\" id=\"desc-module-8\" src=\"http://assets.alicdn.com/kissy/1.0.0/build/imglazyload/spaceball.gif\" />\n  <div>\n   <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i2/2289469223/TB2NHIwq9XlpuFjy0FeXXcJbFXa_!!2289469223.jpg\" />\n   <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i2/2289469223/TB20sg.q9xjpuFjSszeXXaeMVXa_!!2289469223.jpg\" />\n   <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i3/2289469223/TB21ds7q3xlpuFjSszgXXcJdpXa_!!2289469223.jpg\" />\n   <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i4/2289469223/TB2vP70qYtlpuFjSspfXXXLUpXa_!!2289469223.jpg\" />\n   <img align=\"absmiddle\" src=\"http://img.alicdn.com/imgextra/i3/2289469223/TB25LDodH5K.eBjy0FnXXaZzVXa_!!2289469223.jpg\" />\n   <div>\n    &nbsp;\n   </div>\n  </div>\n  <p>&nbsp;</p>\n  <script src=\"https://g.alicdn.com/i/popshop/0.0.23/p/seemore/load.js?c\"></script> \n </body>\n</html>";
//		System.out.println(getDetailImgslist(init));
		
		
		System.out.println(new SpiderServiceImpl().getDetailImgslist(init));
		
		
	}

	public String getTaobaoTmallDetailImgs() {
		return taobaoTmallDetailImgs;
	}

	public void setTaobaoTmallDetailImgs(String taobaoTmallDetailImgs) {
		this.taobaoTmallDetailImgs = taobaoTmallDetailImgs;
	}

	public String getJdDetailImgs() {
		return jdDetailImgs;
	}

	public void setJdDetailImgs(String jdDetailImgs) {
		this.jdDetailImgs = jdDetailImgs;
	}
	
	

}
