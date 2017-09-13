/******************************************************************************
 * @File name   :      LoginController.java
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
 * 2017年9月8日 上午10:21:39        niklaus     1.0            Initial Version
 *****************************************************************************/
package cn.zhangxd.platform.mobile.client.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.zhangxd.platform.mobile.client.util.R;


/**
 *
 */
@RestController
@RequestMapping("/api/{version}/login")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.appsecret}")
    private String appsecret;
    @Value("${wechat.rediecturi}")
    private String rediecturi;
	
	@RequestMapping("/wechat")
	public R wechat(
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "code", required = false) String code,
			@RequestParam(value = "redirectUrl", required = false, defaultValue = "") String redirectUrl,
			@RequestParam(value = "state", required = false, defaultValue = "") String state,
			@RequestParam(value = "redirectDomain", required = false, defaultValue = "") String redirectDomain) {
		logger.info("----------------Auth code:{}" ,code);
		// 1. 获取code 通过微信回调到当前页面获取  
		if(StringUtils.isEmpty(code) && StringUtils.isEmpty(state)){
			logger.info("发起微信登陆 ,跳转至微信授权页面");
			
			try {
				// 跳转至授权页  将redirectUrl赋值给state 回调后微信将带回
				state = StringUtils.isEmpty(redirectUrl) ? "STATE" : redirectUrl;
				state = URLEncoder.encode(state, "UTF-8");
				if(state.length() > 128){
					state = "STATE";
				}
				
				//http://lottery.taolue.fm/shop/user/wxlogin 微信回调URI
				String auth_redirect_uri = rediecturi;
				//不论域名是否微信配置的域名，直接跳回当前域名
				if (rediecturi.indexOf(request.getServerName()) < 0) {
					if (auth_redirect_uri.indexOf("?") > 0) {
						auth_redirect_uri += "&redirectDomain=" + request.getServerName();
					} else {
						auth_redirect_uri += "?redirectDomain=" + request.getServerName();
					}
				}
				auth_redirect_uri = URLEncoder.encode(auth_redirect_uri, "UTF-8");
				
				StringBuilder sb = new StringBuilder();
				sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=").append(appid);
				sb.append("&redirect_uri=").append(auth_redirect_uri);
				sb.append("&response_type=code");
				sb.append("&scope=snsapi_userinfo");
				sb.append("&state=" + state);
				sb.append("#wechat_redirect");
				response.sendRedirect(sb.toString());
			} catch (UnsupportedEncodingException e) {
				logger.error("UnsupportedEncodingException {}", e);
			} catch (IOException e) {
				logger.error("IOException :{}", state);
			}
			
		}if("authdeny".equals(code) && !StringUtils.isEmpty(state)){
			// 用户取消 授权
			logger.info("用户取消授权,跳转至用户主页");
			return R.error(101,code);
		} else if (!StringUtils.isEmpty(code)){
			logger.info("用户授权成功");
			Map<String, Object> map  = new HashMap<String, Object>();
			//判断是否需要代理跳转
			///shop/user/wxlogin?redirectDomain=radiomall.cn&code=021uDHb31gvw9L1J07c31kwNb31uDHbu&state=STATE
			try {
				if (!StringUtils.isEmpty(redirectDomain) && !redirectDomain.equals(request.getServerName())) {
					String uri = request.getRequestURI();
					String targetUrl = "http://" +  redirectDomain + uri + "?code=" + code + "&state=" + URLEncoder.encode(state, "UTF-8");
					response.sendRedirect(targetUrl);
					return null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
			return R.ok(map);
			
		}
		return R.ok();
	}
	
	
	
	
	

}
