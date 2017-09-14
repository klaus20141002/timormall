package zhizhu.cy.platform.system.api.exception;


import zhizhu.cy.platform.system.api.exception.base.BusinessException;

/**
 * 无效验证码
 *
 * @author zhangxd
 */
public class InvalidCaptchaException extends BusinessException {

    public InvalidCaptchaException(String message) {
        super(message);
    }

}
