/**
 *Project Name： spu-data-handle
 *Package Name:com.bezuo.spu_data_handle.common 
 *File Name：Const.java
 *Date:2016年4月20日 上午10:25:21
 *Copyright(c)2016,必做网络科技 All Rights Reserved
 */
package com.klauting.timormall.system.api.constant;

/**
 * 常量类 ClassName: Const
 * 
 * @since: JDK 1.8 Date: 2016年4月20日 上午10:25:21
 * @author: HANWEIDONG
 */
public class Const {

	/** spu信息的爬取状态--未爬取 */
	public static final String SKU_CRAWING_NOT_COMPLETE = "0";
	/** spu信息的爬取状态--完成 */
	public static final String SKU_CRAWING_COMPLETE = "1";
	/** 分销信息的爬取状态--未爬取 */
	public static final String DISTRIBUTION_CRAWING_NOT_COMPLETE = "0";
	/** 分销信息的爬取状态--完成 */
	public static final String DISTRIBUTION_CRAWING_COMPLETE = "1";

	/** 分销信息类型 */
	public static class RateType {
		/** common: 通用比率 */
		public static final String COMMON = "common";
		/** event: 高佣比率 */
		public static final String EVENT = "event";
	}

	/** spu,sku是否可用状态 */
	public static class IsUseType {
		/** 状态1: 可用 */
		public static final int ON_SALE = 1;

		/** 状态2: 不可用, 商品下架，或区域卖光 */
		public static final int SALE_OFF = 2;
		public static final String SALE_OFF_REASON = "该商品已下架或区域卖光.";

		/** 状态3: 不可用，商品数量低于最低限制,进行下架处理 */
		public static final int QUALITY_LIMIT = 3;
		public static final String QUALITY_LIMIT_REASON = "不可用,商品数量低于最低限制.";

		/** 状态4: 不可用，sku价格高于最大限制,进行下架处理 */
		public static final int PRICE_LIMIT = 4;

		/** 状态5: 不可用，sku没有再次发现 */
		public static final int SKU_NOT_FOUND = 5;
		public static final String SKU_NOT_FOUND_REASON = "不可用,新爬取的信息中,这个sku没有被发现.";

		/** 状态6: 不可用，所有的sku不可用，spu不可用 */
		public static final int ALL_SKU_UNAVAILABLE = 6;
		public static final String ALL_SKU_UNAVAILABLE_REASON = "不可用,所有的sku不可用.";

		/** 状态7:不可用，分销比率低 */
		public static final int DISTRIBUTION_RATE_LOW = 7;
		public static final String DISTRIBUTION_RATE_LOW_REASON = "不可用,分销比率过低.";

		/** 状态8:不可用，人工下架 */
		public static final int MANUAL_DOWN_SHELF = 8;
		public static final String MANUAL_DOWN_SHELF_REASON = "不可用,人工下架.";

		/** 状态9:不可用，分销信息不存在 */
		public static final int NO_DISTRIBUTION_INFO = 9;
		public static final String NO_DISTRIBUTION_INFO_REASON = "不可用,分销信息不存在.";

		/** 状态10:不可用，高佣分销信息已快到期 */
		public static final int EVENT_RATE_EXPIRE = 10;
		public static final String EVENT_RATE_EXPIRE_REASON = "不可用,高佣分销信息已快到期.";

		/** 状态11:不可用,jd商品没有获取到sku价格信息或获取价格信息异常 */
		public static final int ERROR_PRICE_INFO = 11;
		public static final String ERROR_PRICE_INFO_REASON = "不可用,jd商品没有获取到sku价格信息或获取价格信息异常.";

		/** 状态12:不可用,jd商品没有获取到sku库存信息或获取库存信息出现异常 */
		public static final int ERROR_QUALITY_INFO = 12;
		public static final String ERROR_QUALITY_INFO_REASON = "不可用,jd商品没有获取到sku库存信息或获取库存信息出现异常.";

		/** 状态13:不可用,jd商品的分销信息快到期 */
		public static final int JD_TKRATE_EXPIRE = 13;
		public static final String JD_TKRATE_EXPIRE_REASON = "不可用,jd商品的分销信息快过期.";

		/** 状态14:不可用,商品的有邮费 */
		public static final int HAVE_DELIVERY_FEES = 14;
		public static final String HAVE_DELIVERY_FEES_REASON = "不可用,商品含有邮费.";

	}

	/** 一个spu是否含有sku */
	public static class IsContainSku {
		/** 这个商品含有sku */
		public static final String CONTAIN_SKU = "1";
		/** 这个商品只有spu,没有sku */
		public static final String NOT_CONTAIN_SKU = "2";
	}

	/**
	 * 商品类型
	 */
	public static class GoodsType {
		public static final String PROMOTION_GOODS = "0"; // 促销商品
		public static final String COMMON_GOODS = "1"; // 普通商品
	}

	/**
	 * 平台类型
	 */
	public static class Platform {
		public static final String TAOBAO_ID = "1";
		public static final String TMALL_ID = "2";
		public static final String JD_ID = "3";
	}

	/**
	 * 任务描述
	 */
	public static class TaskDesc {
		public static final String TAOBAO_TMALL_SPUINFO_TASK = "淘宝天猫-spu信息任务";
		public static final String TAOBAO_TMALL_DISTRIBUTION_TASK = "淘宝天猫-分销信息任务";
		public static final String TAOBAO_TMALL_DETAIL_IMGS_TASK = "淘宝天猫-详情图片任务(获取商品页面源代码)";
		public static final String TAOBAO_TMALL_DETAIL_IMGS_URL_TASK = "淘宝天猫-详情图片URL任务";
		public static final String JD_SPUINFO_TASK = "JD-spu信息任务";
		public static final String JD_DISTRIBUTION_TASK = "JD-分销信息任务";
		public static final String JD_DETAIL_IMGS_TASK = "JD-详情图片任务";
		public static final String JD_SKU_PRICE_TASK = "JD-sku价格信息任务";
		public static final String JD_SKU_QUANTITY_TASK = "JD-sku库存信息任务";
	}

	/**
	 * 任务状态
	 */
	public static class TaskStatus {
		public static final String FAILED = "FAILED";
		public static final String OK = "OK";
	}

	/** 分销信息类型,商品基本信息表中的分销类型 */
	public static class GoodsRateType {
		/** common: 通用比率 */
		public static final String COMMON = "0";
		/** event: 高佣比率 */
		public static final String HIGH = "1";
		/** event: 定向比率 */
		public static final String DIGNXIANG = "2";
	}
}
