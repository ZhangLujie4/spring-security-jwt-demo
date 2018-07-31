package com.zlj.final_security_exercise.enums;

import lombok.Getter;

/**
 * @author tori
 * 2018/7/30 下午1:33
 */
@Getter
public enum SecurityStatus {

    LOGIN_FAILED(1, "登录失败"),

    DATA_SOURCE_EMPTY(2, "数据库内无数据")
    ;

    private Integer code;

    private String msg;

    SecurityStatus(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
