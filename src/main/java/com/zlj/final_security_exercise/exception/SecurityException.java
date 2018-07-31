package com.zlj.final_security_exercise.exception;

import com.zlj.final_security_exercise.enums.SecurityStatus;

/**
 * @author tori
 * 2018/7/30 下午1:29
 */
public class SecurityException extends RuntimeException {

    private Integer code;

    public SecurityException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public SecurityException(SecurityStatus securityStatus) {
        super(securityStatus.getMsg());
        this.code = securityStatus.getCode();
    }
}
