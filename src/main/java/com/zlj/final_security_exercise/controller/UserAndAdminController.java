package com.zlj.final_security_exercise.controller;

import com.zlj.final_security_exercise.VO.ResultVO;
import com.zlj.final_security_exercise.dataobject.SecurityUser;
import com.zlj.final_security_exercise.dataobject.UserAuthentication;
import com.zlj.final_security_exercise.dataobject.UserDO;
import com.zlj.final_security_exercise.enums.SecurityStatus;
import com.zlj.final_security_exercise.exception.SecurityException;
import com.zlj.final_security_exercise.form.LoginForm;
import com.zlj.final_security_exercise.security.TokenProvider;
import com.zlj.final_security_exercise.service.UserService;
import com.zlj.final_security_exercise.utils.Blowfish;
import com.zlj.final_security_exercise.utils.ResultVOUtil;
import com.zlj.final_security_exercise.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tori
 * 2018/7/30 上午10:46
 */

@RestController
@RequestMapping("/api/user")
public class UserAndAdminController {

    @Autowired
    private TokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @GetMapping("/current")
    public ResultVO<SecurityUser> getCurrentUser() {
        UserDO userDO = new UserDO();
        return ResultVOUtil.success(SecurityUtil.getCurrentUser());
    }

    @PostMapping("/login")
    public ResultVO login(@RequestBody LoginForm loginForm) throws Exception {
        UserDO userDO = userService.findByUsername(loginForm.getUsername());
        if (null == userDO) {
            throw new SecurityException(SecurityStatus.LOGIN_FAILED);
        }

        String encodePwd = Blowfish.encode(loginForm.getPassword());
        if (!userDO.getPassword().equals(encodePwd)) {
            throw new SecurityException(SecurityStatus.LOGIN_FAILED);
        }

        Map<String, String> map = new HashMap<>();
        UserAuthentication userAuthentication = new UserAuthentication(SecurityUtil.convertUser(userDO));
        String token = tokenProvider.createToken(userAuthentication);
        map.put("token", token);
        map.put("role", userDO.getRole().toString());
        return ResultVOUtil.success(map);
    }
}
