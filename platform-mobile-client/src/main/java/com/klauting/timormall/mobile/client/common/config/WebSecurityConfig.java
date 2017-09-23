package com.klauting.timormall.mobile.client.common.config;

import com.klauting.timormall.common.web.config.AbstractWebSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;

/**
 * spring-security配置
 *
 * @author zhangxd
 */
@Configuration
public class WebSecurityConfig extends AbstractWebSecurityConfig {

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略权限校验的访问路径
        web
            .ignoring()
            .antMatchers(
                "/favicon.ico",
                "/swagger**/**",
                "/*/api-docs",
                "/webjars/**",
                "/api/*/sms/captcha",
                "/api/*/user/password",
                "/*/currency/**",
                "/api/*/login/**",
                "/api/*/address/**",
                "/api/*/merchant/**",
                "/api/*/food/**",
                "/api/*/order/**",
                "/api/*/orderfoods/**",
                "/api/*/ordercomment/**",
                "/api/*/orderlog/**",
                "/api/*/user/**"
            )
            .antMatchers(HttpMethod.POST, "/*/user")
            .antMatchers(HttpMethod.PUT, "/*/user")
        ;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/*/auth/token").permitAll();
        super.configure(security);
    }
}
