package zhizhu.cy.platform.system.api.exception.base;

/**
 * 业务异常.
 *
 * @author zhangxd
 */
public class BusinessException extends Exception {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }

}