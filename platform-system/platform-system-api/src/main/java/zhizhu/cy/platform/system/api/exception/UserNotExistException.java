package zhizhu.cy.platform.system.api.exception;


import zhizhu.cy.platform.system.api.exception.base.BusinessException;

/**
 * 用户未存在
 *
 * @author zhangxd
 */
public class UserNotExistException extends BusinessException {

    public UserNotExistException(String message) {
        super(message);
    }

}
