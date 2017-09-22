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
package zhizhu.cy.platform.mobile.client.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import zhizhu.cy.platform.common.redis.RedisRepository;
import zhizhu.cy.platform.mobile.client.security.utils.TokenUtil;
import zhizhu.cy.platform.mobile.client.util.R;
import zhizhu.cy.platform.system.api.dto.WechatUserInfo;
import zhizhu.cy.platform.system.api.entity.TripUser;
import zhizhu.cy.platform.system.api.service.ITripUserService;


/**
 *
 */
@RestController
@RequestMapping("/api/{version}/login")
@Api(tags="登陆")
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.appsecret}")
    private String appsecret;
    @Value("${wechat.rediecturi}")
    private String rediecturi;
    @Value("${wechat.getaccessurl}")
    private String getaccessurl;
    @Value("${wechat.getuserbaseinfo}")
    private String getuserbaseinfo;
    
    /**
     * 缓存前缀
     */
    private static final String REDIS_PREFIX_ACCESS_TOKEN = "access_token_";
    
    /**
     * 用户服务
     */
    @Autowired
    private ITripUserService tripUserService;
    
    /**
     * 密码加密
     */
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    /**
     * redis repository
     */
    @Autowired
    private RedisRepository redisRepository;
    
    
    /**
     * 权限管理
     */
    @Autowired
    private AuthenticationManager authenticationManager;
    /**
     * Token工具类
     */
    @Autowired
    private TokenUtil jwtTokenUtil;
    
    
    
	
	@RequestMapping("/wechat")
	@ApiOperation(value="微信登陆")
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
			Map<String, Object> tokenMap  = new HashMap<String, Object>();
			//判断是否需要代理跳转
			///shop/user/wxlogin?redirectDomain=radiomall.cn&code=021uDHb31gvw9L1J07c31kwNb31uDHbu&state=STATE
			try {
				if (!StringUtils.isEmpty(redirectDomain) && !redirectDomain.equals(request.getServerName())) {
					String uri = request.getRequestURI();
					String targetUrl = "http://" +  redirectDomain + uri + "?code=" + code + "&state=" + URLEncoder.encode(state, "UTF-8");
					response.sendRedirect(targetUrl);
					return null;
				}
				
				R result = getAccessTokenAndOauthUserInfo(request, response, code);
				WechatUserInfo userInfo = (WechatUserInfo)result.get("userinfo") ;
				
				//存入 Redis
		        redisRepository.setExpire(REDIS_PREFIX_ACCESS_TOKEN + userInfo.getOpenId(), userInfo.getAccess_token(), 2 * 60 * 60); //俩小时有效期
				
				TripUser user = tripUserService.getByOpenId(userInfo.getOpenId());
				if(user == null) {
					user = new TripUser();
					user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
					user.setUserId(userInfo.getOpenId());
					user.setPassword(passwordEncoder.encode(userInfo.getOpenId()));
					user.setCreateTime(new Date());
					user.setUpdateTime(new Date());
					user.setEnabled(true);
					user.setGender(String.valueOf(userInfo.getSex()));
					user.setNickname(userInfo.getNickname());
					user.setPhoto(userInfo.getHeadimgurl());
					user.setRemarks(userInfo.getCountry()+userInfo.getProvince()+userInfo.getCity());
					// 注册
					tripUserService.registryUserByWechat(user);
				}
				
				//完成授权
		        final Authentication authentication = authenticationManager.authenticate(
		            new UsernamePasswordAuthenticationToken(userInfo.getOpenId(), userInfo.getOpenId())
		        );
		        SecurityContextHolder.getContext().setAuthentication(authentication);

		        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		        final String token = jwtTokenUtil.generateToken(userDetails); //生成Token

		        
		        tokenMap.put("access_token", token);
		        tokenMap.put("expires_in", jwtTokenUtil.getExpiration());
		        tokenMap.put("token_type", TokenUtil.TOKEN_TYPE_BEARER);

//		        Map<String, Object> message = new HashMap<>();
//		        message.put(Message.RETURN_FIELD_CODE, ReturnCode.SUCCESS);
//		        message.put(Message.RETURN_FIELD_DATA, tokenMap);
				
		        tokenMap.put("data", user);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			return R.ok(tokenMap);
		}
		return R.ok();
	}
	
	
	
	

	
	
	public R getAccessTokenAndOauthUserInfo(HttpServletRequest request, HttpServletResponse response, String code) {
		// 2. 获取 access_token
		logger.info("微信授权中  获取access_token... ");
		String accessToken = null;
		String openid = null;
		WechatUserInfo userinfo = null ;
		Map<String,Object> map = new HashMap<String,Object>();
		Response responseForToken;
		try {
			String url = getaccessurl.replaceFirst("WX_APPID", appid).replaceFirst("WX_APPSECRET", appsecret).replaceFirst("CODE", code);
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
