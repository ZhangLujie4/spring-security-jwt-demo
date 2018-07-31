package com.zlj.final_security_exercise.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author tori
 * 2018/7/30 下午12:01
 */

@Data
public class LoginForm {

    @NotNull
    private String username;

    private String password;
}
