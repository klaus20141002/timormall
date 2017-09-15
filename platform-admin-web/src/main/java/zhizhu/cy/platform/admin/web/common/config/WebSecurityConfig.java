package zhizhu.cy.platform.admin.web.common.config;

import zhizhu.cy.platform.common.web.config.AbstractWebSecurityConfig;
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
                "/*/user/password",
                "/*/currency/**",
                "/sys/*/desk/**",
                "/sys/*/address/**",
                "/sys/*/food/**",
                "/sys/*/foodproperty/**",
                "/sys/*/foodsku/**",
                "/sys/*/merchant/**",
                "/sys/*/order/**",
                "/sys/*/property/**",
                "/sys/*/value/**",
                "/sys/*/propvalue/**",
                "/sys/*/categery/**"
            )
            .antMatchers(HttpMethod.POST, "/*/user")
        ;
    }

	
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/auth/token").permitAll();
        super.configure(security);
    }
}
