package com.zlj.final_security_exercise.controller;

import com.zlj.final_security_exercise.VO.ResultVO;
import com.zlj.final_security_exercise.dataobject.SecurityUser;
import com.zlj.final_security_exercise.dataobject.UserDO;
import com.zlj.final_security_exercise.enums.SecurityStatus;
import com.zlj.final_security_exercise.exception.SecurityException;
import com.zlj.final_security_exercise.service.UserService;
import com.zlj.final_security_exercise.utils.ResultVOUtil;
import com.zlj.final_security_exercise.utils.SecurityUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tori
 * 2018/7/30 上午10:47
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

//    @GetMapping("/findAll")
//    public ResultVO<List<Map<String, Object>>> findAll() {
//        List<UserDO> userDOS = userService.findAll();
//        List<Map<String, Object>> result = new ArrayList<>();
//        Map<String, Object> map;
//        if (CollectionUtils.isEmpty(userDOS)) {
//            throw new SecurityException(SecurityStatus.DATA_SOURCE_EMPTY);
//        }
//        for (UserDO userDO : userDOS) {
//            map = new HashMap<>();
//            SecurityUser securityUser = SecurityUtil.convertUser(userDO);
//            map.put("username", securityUser.getUsername());
//            map.put("userId", securityUser.getUserId());
//            map.put("authorities",
//                    securityUser.getAuthorities()
//                            .stream().map(authority->authority.getAuthority()).collect(Collectors.joining(",")));
//            result.add(map);
//        }
//
//        return ResultVOUtil.success(result);
//    }

    @GetMapping("/findAll")
    public ResultVO<List<SecurityUser>> findAll() {
        List<UserDO> userDOS = userService.findAll();
        List<SecurityUser> result = new ArrayList<>();
        if (CollectionUtils.isEmpty(userDOS)) {
            throw new SecurityException(SecurityStatus.DATA_SOURCE_EMPTY);
        }
        for (UserDO userDO : userDOS) {
            SecurityUser securityUser = SecurityUtil.convertUser(userDO);
            result.add(securityUser);
        }

        return ResultVOUtil.success(result);
    }
}
