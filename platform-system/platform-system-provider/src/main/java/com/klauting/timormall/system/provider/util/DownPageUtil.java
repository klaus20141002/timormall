package com.klauting.timormall.system.provider.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.utils.UrlUtils;

public class DownPageUtil {
	
	
	
	private static final int READ_TIMEOUT = 180;
	
	private static final Logger logger = LoggerFactory.getLogger(DownPageUtil.class);
	
	/**
	 * 得到页面的json内容,生成Json对象  ,注意传入的url是转码后的
	 * @param goodsEncodeUrl
	 * @param taskTime
	 * @param taskDes
	 * @return
	 */
	public Json getLoadJSON( String goodsEncodeUrl, String taskDesc ) {
		String pageStr = loadPageContent(goodsEncodeUrl, taskDesc);
		if( pageStr != null && !pageStr.isEmpty()){
			return new Json(pageStr);
		}else{
			return null;
		}
	}
	
	/**
	 * 生成页面的html内容，主要用于京东商品的爬取Html.xpath()，注意传入的url没有经过转码
	 * @param goodsUrl
	 * @param taskTime
	 * @param taskDes
	 * @return
	 */
	public Html getLoadHtml( String goodsUrl, String taskDesc){
		String pageStr = loadPageContent(goodsUrl, taskDesc);
		if( pageStr != null && ! pageStr.isEmpty()){
			return new Html( UrlUtils.fixAllRelativeHrefs(pageStr,goodsUrl) );
		}else{
			return null;
		}
	}

	
	public String loadPageContent(String url, String taskDesc) {
		BufferedReader in = null;
		try {
			URL page = new URL(url);
			URLConnection con = page.openConnection();

			in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine = null;

			StringBuilder pageStr = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
				pageStr.append(inputLine);
			}
			return pageStr.toString();
		} catch (Exception e) {
			logger.error(" 异常！URL内容获取失败 ！任务描述={}, url={}, error_msg={} ", taskDesc, url, e.toString());
		} finally {
			IOUtils.closeQuietly(in);
		}
		return "";
	}
	
	public Html downLoadHtml(String url, String taskDesc, String charset) {
		String pageStr = downLoadContent(url, taskDesc, charset);
		if( !StringUtils.isEmpty(pageStr)){
			return new Html( UrlUtils.fixAllRelativeHrefs(pageStr, url) );
		}else{
			return null;
		}
    }
	
	public String downLoadContent(String url, String taskDesc, String charset){
		// "gb2312"
        HttpClient client = new DefaultHttpClient(); // HttpClients.custom().setDefaultCookieStore( cookieStore ).build(); // new DefaultHttpClient();
        StringBuffer result = new StringBuffer();
        try {
			 HttpGet request = new HttpGet(url);
				request.addHeader("User-Agent" , ":Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36" );
				HttpResponse response = client.execute(request);
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), charset));
				String line = "";
				while ((line = bufferedReader.readLine()) != null) {
					result.append(line);
				}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(" 异常！页面信息爬取失败 ！任务类型描述={},goodsUrl={}",taskDesc,url);
			return null;
		}
       
		return result.toString();
    }
	
	
	public static String downloadPage(String url) {
		
		
		OkHttpClient client = new OkHttpClient().newBuilder()
	            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
	            .build();

        HttpUrl getUrl = HttpUrl.parse(url).newBuilder()
            .build();
        logger.info("downloadPage start .....................");
        Request request = new Request.Builder()
            .url(getUrl)
            .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String message = response.body().string();
                return message;
            }
        }catch (Exception e) {
        	logger.error("downloadPage error",e);
		}
        return null;
	}



}
