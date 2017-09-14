/******************************************************************************
 * @File name   :      WechatUtil.java
 *
 * @Author      :      niklaus
 *
 * @Date        :      2017年9月8日
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
 * 2017年9月8日 上午11:32:27        niklaus     1.0            Initial Version
 *****************************************************************************/
package zhizhu.cy.platform.mobile.client.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import zhizhu.cy.platform.system.api.dto.WechatUserInfo;


/**
 *
 */
public class WechatUtil {
	private static Logger logger = LoggerFactory.getLogger(WechatUtil.class);
	
	@Value("${wechat.appid}")
    private static String appid;
    @Value("${wechat.appsecret}")
    private static String appsecret;
    @Value("${wechat.rediecturi}")
    private static String rediecturi;
    @Value("${wechat.getaccessurl}")
    private static String getaccessurl;
    @Value("${wechat.getuserbaseinfo}")
    private static String getuserbaseinfo;
	
	
	public R getAccessTokenAndOauthUserInfo(HttpServletRequest request, HttpServletResponse response, String code) {
		// 2. 获取 access_token
		logger.info("微信授权中  获取access_token... ");
		String accessToken = null;
		String openid = null;
		WechatUserInfo userinfo = null ;
		Map<String,Object> map = new HashMap<String,Object>();
		Response responseForToken;
		try {
			String url = getaccessurl;
			url.replace("WX_APPID", appid);
			url.replace("WX_APPSECRET", appsecret);
			url.replace("CODE", code);
			Connection con = Jsoup.connect(url);
			responseForToken = con.execute();
			logger.info("数据读取成功...");
			if (null != responseForToken) {
				String jsonData = responseForToken.body();
				logger.info("获取内容成功... body={}", jsonData);
				JSONObject data = JSONObject.parseObject(jsonData);
				openid = data.getString("openid");
				accessToken = data.getString("access_token");
				// 3. 获取用户基本信息
				if (!StringUtils.isEmpty(accessToken) && !StringUtils.isEmpty(openid)) {
					userinfo = getOauthUserInfo(request, response, openid, accessToken);
					
				}else{
					logger.error("program error|微信授权 获取access_token或openid为空|response={} code={} openId={} ", jsonData, code, openid);
					return R.error(102, "微信授权 获取access_token或openid为空");
				}
			}else{
				logger.error("program error|微信授权异常 返回结果为空|code={}, url={}", code, url);
				return R.error(102, "微信授权异常 返回结果为空");
			}

		} catch (IOException e) {
			logger.error("program error|微信授权异常|code={}, e={} ", code, e.getMessage());
			return null;
		}
		map.put("userinfo", userinfo);
		return R.ok(map);

	}
	
	
	public WechatUserInfo getOauthUserInfo(HttpServletRequest request, HttpServletResponse response, String openid, String accessToken) {
		Response responseForToken;
		WechatUserInfo userInfo = null;
		String url = getuserbaseinfo.replaceAll("OPENID", openid).replaceAll("ACCESS_TOKEN", accessToken);
		try {
			responseForToken = Jsoup.connect(url).execute();
			if (null != responseForToken) {
				String jsonData = responseForToken.body();

				userInfo = JSON.parseObject(jsonData, WechatUserInfo.class);
				if(StringUtils.isEmpty(userInfo.getUnionid())){
					logger.error("program error|微信授权获取用户信息异常 unionid为空|openId={}, response={}", openid, jsonData);
					return null;
				}
				userInfo.setAccess_token(accessToken);
			}else{
				logger.error("program error|微信授权获取用户基本信息异常 response返回结果为空|openId={}, access_token={}", openid, accessToken);
				return null;
			}

		} catch (IOException e) {
			logger.error("program error|微信授权获取用户基本信息异常|url={}, e={} ", url, e.getMessage());
			return null;
		}
		logger.info("微信授权完成  获取用户基本信息完成  userInfo={} ", userInfo.toString() );
		return userInfo;
	}
	
}
