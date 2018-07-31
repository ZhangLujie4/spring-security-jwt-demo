package com.zlj.final_security_exercise.utils;

import com.zlj.final_security_exercise.VO.ResultVO;

import javax.xml.transform.Result;

/**
 * @author tori
 * 2018/7/30 上午10:51
 */
public class ResultVOUtil {

    public static ResultVO success(Object content) {
        ResultVO resultVO = new ResultVO();
        resultVO.setStatus("success");
        resultVO.setCode(0);
        resultVO.setContent(content);
        return resultVO;
    }

    public static ResultVO success() {
        return ResultVOUtil.success(null);
    }

}
