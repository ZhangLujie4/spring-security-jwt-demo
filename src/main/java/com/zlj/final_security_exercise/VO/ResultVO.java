package com.zlj.final_security_exercise.VO;

import lombok.Data;

/**
 * @author tori
 * 2018/7/30 上午10:49
 */

@Data
public class ResultVO<T> {

    private String status;

    private Integer code;

    private T content;
}
