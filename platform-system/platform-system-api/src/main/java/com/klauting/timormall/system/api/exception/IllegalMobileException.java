package com.klauting.timormall.system.api.exception;


import com.klauting.timormall.system.api.exception.base.BusinessException;

/**
 * 手机号码不合法
 *
 * @author zhangxd
 */
public class IllegalMobileException extends BusinessException {

    public IllegalMobileException(String message) {
        super(message);
    }

}
