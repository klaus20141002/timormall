package com.klauting.timormall.system.api.exception;


import com.klauting.timormall.system.api.exception.base.BusinessException;

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
