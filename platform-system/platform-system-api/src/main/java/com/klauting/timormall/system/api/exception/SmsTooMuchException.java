package com.klauting.timormall.system.api.exception;


import com.klauting.timormall.system.api.exception.base.BusinessException;

/**
 * 短信发送太频繁
 *
 * @author zhangxd
 */
public class SmsTooMuchException extends BusinessException {

    public SmsTooMuchException(String message) {
        super(message);
    }

}
