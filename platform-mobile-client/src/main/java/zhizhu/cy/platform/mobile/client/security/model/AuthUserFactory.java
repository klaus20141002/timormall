package zhizhu.cy.platform.mobile.client.security.model;

import zhizhu.cy.platform.system.api.entity.TripUser;

/**
 * The type Auth user factory.
 *
 * @author zhangxd
 */
public final class AuthUserFactory {

    private AuthUserFactory() {
    }

    /**
     * Create auth user.
     *
     * @param user the user
     * @return the auth user
     */
    public static AuthUser create(TripUser user) {
        return new AuthUser(
            user.getId(),
            user.getUserId(),
            user.getPassword(),
            user.getEnabled()
        );
    }

}
