package com.klauting.timormall.mobile.client.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.klauting.timormall.common.web.security.model.AbstractAuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Security User
 *
 * @author zhangxd
 */
public class AuthUser extends AbstractAuthUser {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * 用户默认角色
     */
    private static final String TRIP_USER_ROLE = "ROLE_USER";
    /**
     * id
     */
    private String id;
    /**
     * user_id  open_id 
     */
    private String userId;
    
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 冻结
     */
    private boolean enabled;

    public AuthUser(
        String id,
        String userId,
        String password,
        boolean enabled
    ) {
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    

    
    
    @Override
    public String getUsername() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(TRIP_USER_ROLE));
        return authorities;
    }

}
