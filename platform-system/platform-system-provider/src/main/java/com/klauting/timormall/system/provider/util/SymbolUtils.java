package com.klauting.timormall.system.provider.util;

/**
 *
 * @description  常量工具类
 */
public class SymbolUtils {
	
	// 符号
	public static final String COMMA = "|";
	public static final String SPACE = "";
	public static final String ENTER = "\n";
	public static final String CATEGORYSPLIT =">";  // 中英文格式 >
	public static final String DOUBLEQUOTE ="\"";
	public static final String DOUHAO = ",";
	public static final String EQ = "=";
	public static final String AND = "&";
	public static final String PER = "%";
	public static final String LINE = "-";
	public static final String DOLLAR = "¥";
	public static final String URLPARAM = "[?]";
	public static final String URLSPLIT = "[|]";  //标题特殊字符处理 
	public static final String DATEFORMAT = "yyyyMMdd";
	public static final String TIMEFORMAT = "yyyyMMddHHmmsss";
	public static final String LEFTBRACKET = "(";
	public static final String RIGHTBRACKET = ")";
	
	// 字符串替换
	public static final String IMGREGEXSIZE = "\\d{2}x\\w{2,5}.jpg";
	public static final String IMGSIZE = "600x600.jpg";
	public static final String JDGOODSIMGSIZE  = "/n12/";
	public static final String JDGOODSIMGREGEX = "/n\\d+/";  // s75x75_jfs
	public static final String JDGOODCOMMENTSIMGREGEX = "s\\d{2}x\\d{2}_";  // s76x76_jfs
	public static final String JDGOODCOMMENTSIMGSIZE = "s600x600_";
	
	
	// 框架
	public static final String ORIGINURL = "originUrl";
	public static final String CATEGORYINFO = "CATEGORYINFO";  // 类目  	大分类>子分类1
	public static final String TYPE = "type";
	public static final String WEBMAGIC = "webmagic";   // 核心一
	public static final String WEBKIT = "webkit";   // 核心二
	public static final String API = "api";
	public static final String TASKTIME = "taskTime"; // 任务下发时间
	public static final String SCHEDULER = "scheduler";
	public static final String PAGETYPENORMAL = "normal"; //普通页面
	public static final String PAGETYPEACTIVITY = "activity"; //活动页面
	public static final String TASKINFO = "taskInfo";
	
	public static final String CLICKTYPE = "class"; // 页面点击类型   销量 人气   comprehsion
	public static final String PLATFORTYPE = "platformType";  // 平台类型  all tmall 
	public static final String ALLPLATFOR = "all" ;
	public static final String TAOBAOPLATFORM = "taobao";
	public static final String TMALLPLATFORM = "tmall";
	public static final String SUBCLASSIFICATION = "subclassification";  // 勾选操作
	public static final String PRODUCTID = "productId";
	//public static final String EXTRAINFO = "extraInfo";
	
	// JD
	public static final String JDPLATFORMID = "3";
	public static final String JDCATEGORYLIST = "jd_list";   // JD分类list
	public static final String JDPRODUCTLIST = "jd_product_list";  // 商品列表list
	public static final String JDPRODUCTINFO = "jd_product_info";  // 商品详情
	public static final String JDPRODUCTINFOBOUTIQUE = "jd_product_info_boutique";  // 商品   精品 详情
	public static final String JDCOMMENT = "jd_product_comment"; // 京东评论页
	public static final String JDBOOKLIST = "jd_book_list";  // 京东图片list 
	
	public static final String JD_DISTRIBUTION_API = "jd_distribution_api"; // 京东分销信息api
	public static final String JD_SKU_INFO = "jd_sku_info"; // 京东sku信息提取
	public static final String JD_PROMO_SKUIDS = "JD_PROMO_SKUIDS"; // 京东skuid串
	public static final String JD_PROMO_INFO_LIST = "jd_promo_info_list"; // 京东分销信息列表
	
	// taobao
	public static final String TAOBAOPLATFORMID = "1";
	public static final String TMALLTAOBAOLIST = "tmall_taobao_list"; // 淘宝 天猫  品类list总入口
	public static final String TMALLTAOBAOPRODUCTLIST = "tmall_taobao_product_list";   //  淘宝 天猫  商品列表总入口  淘宝 天猫  阿里妈妈api商品列表总入口
	public static final String TAOBAOPRODUCTINFOBOUTIQUE = "taobao_product_info_boutique";   // 淘宝  精品 商品信息
	public static final String TAOBAOPRODUCTINFO = "taobao_product_info";   // 淘宝  商品计算信息
	public static final String TAOBAOPRODUCTINFOAPIACCESS = "taobao_product_info_api";   // 淘宝  商品 API 计算信息
	//public static final String TAOBAOPRODUCTINFOBOUTIQUEAPI = "taobao_product_info_boutique_api";
	public static final String TAOBAOPRODUCTDECAL = "taobao_product_dealrecord"; // 成交记录页面
	public static final String TAOBAOPRODUCTCOMMT = "taobao_product_comment";   //  淘宝 商品评论
	public static final String TAOBAOPRODUCTQINGINFO = "taobao_product_clearance_info"; // 淘宝清仓info
	public static final String TAOBAO_DISTRIBUTION_API = "taobao_distribution_api"; // 淘宝分销信息api
	
	// tmall
	public static final String TMALLPLATFORMID = "2";
	public static final String TMALLCOM = "tmall.com";
	public static final String TMALLPRODUCTINFO = "tmall_product_info";   // 天猫 商品信息
	public static final String TMALLPRODUCTINFOAPIACCESS = "tmall_product_info_api";   // 天猫 商品 API 信息
	public static final String TMALLPRODUCTINFOBOUTIQUE = "tmall_product_info_boutique";   // 天猫   精品  商品信息
	public static final String TMALLPRODUCTINFOBOUTIQUEAPI = "tmall_product_info_boutique_api";
	public static final String TMALLPRODUCTDECAL = "tmall_product_dealrecord"; // 成交记录页面
	public static final String TMALLPRODUCTCOMMENT = "tmall_product_comment";   // 天猫 商品评论
	public static final String TMALL_DISTRIBUTION_API = "tmall_distribution_api"; // 淘宝分销信息api
	
	
	
	// Pipeline 
	public static final String PRODUCTLIST = "product_list";
	public static final String PRODUCTAPILIST = "product_api_list";
	public static final String PRODUCTINFO = "product_info";   // 存储计算排行商品信息
	public static final String PRODUCTINFOLIST = "product_info_list";   // 存储计算排行商品信息list
	public static final String PRODUCTINFOBOUTIQUE = "product_info_boutique";  // 存储商品精品 信息
	public static final String PRODUCTCOMMENT = "product_comment";  
	public static final String PRODUCTPROMO = "product_promo"; // 商品分销信息
	public static final String PRODUCTACTIVEQINGINFO = "product_active_qing_info"; //淘宝清仓信息
	public static final String GOODS_MODEL = "goods_model";  // 商品基本信息
	public static final String PRODUCTSALEOFF = "product_sale_off";  // 下架商品
	public static final String SKU_INFO_MAP = "sku_info_map";  // 商品的基本信息  
	public static final String DISTRIBUTION_INFO = "distribution_info";  // 淘宝天猫商品的分销信息  
	public static final String DAILY_DISTRIBUTION_INFO = "daily_distribution_info";  // 每天定时爬取淘宝天猫商品的分销信息
	
	// 计算得出参数
	public static final String UPINDEX = "upIndex";  // 上升比
	public static final String DAYCOMMENTCOUTN = "dayCommentCount"; // 日评论数
	public static final String DAYSALECOUNT = "daySaleCount"; // 日销量
	public static final String DAYSALEMONEY = "daySaleMoney"; // 日销售额
	public static final String GOODSDBTYPE ="goodsDBType"; // 商品入库标识  插入 更新
	
	// config url 屏蔽参数
	public static final String TAOBAOTMALLREMOVECATEGORY = "removeTaobaoTmallCategory";
	public static final String JDREMOVECATEGORY = "removeJDCategory";
	public static final String AMAZONREMOVECAATEGORY = "removeAmazonCategory";
	
	public static final String DEBUG_LOGS_STATSU = "debug_logs_status"; // 本地文件生成开启状态  true
	public static final String DEBUG_LOGS_PATH = "debug_logs_path"; // 本地文件生成盘  E: 
	public static final String EMPTYSLEEPTIME = "emptySleepTime";
	public static final String taobao_tmall_list_limit = "taobao_tmall_list_limit"; //每次页面提取前多少条数据
	public static final String taobao_tmall_saleCount_limit = "product_list_saleCount_limit"; // 列表页销售限止
	public static final String TAOBAO_SALEOFF_QUANTITY_LIMIT = "taobao_saleoff_quantity_limit"; // 淘宝库存下架限止
	public static final String TAOBAO_SALEOFF_RATECOUNTS_LIMIT = "taobao_saleoff_rateCounts_limit"; // 商品评论低于某值时视下架处理
	
	public static final String TAOBAO_API_SLEEPTIME_LIMIT = "taobao_api_sleepTime_limit"; // 淘宝api任务线程休眠时间
	

	
}
