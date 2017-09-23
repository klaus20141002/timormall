package com.klauting.timormall.mobile.client.security;

import com.klauting.timormall.mobile.client.security.model.AuthUserFactory;
import com.klauting.timormall.system.api.entity.TripUser;
import com.klauting.timormall.system.api.service.ITripUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Security User Detail Service
 *
 * @author zhangxd
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /**
     * 用户服务
     */
    @Autowired
    private ITripUserService tripUserService;

    @Override
    public UserDetails loadUserByUsername(String loginName) {
//        TripUser user = tripUserService.getByMobile(loginName);
        TripUser user = tripUserService.getByOpenId(loginName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", loginName));
        } else {
            return AuthUserFactory.create(user);
        }
    }
}
