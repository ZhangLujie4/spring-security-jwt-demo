package com.zlj.final_security_exercise.repository;

import com.zlj.final_security_exercise.FinalSecurityExerciseApplicationTests;
import com.zlj.final_security_exercise.dataobject.UserDO;
import com.zlj.final_security_exercise.dataobject.UserRoleEnum;
import com.zlj.final_security_exercise.utils.Blowfish;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author tori
 * 2018/7/30 下午1:42
 */
public class UserRepositoryTest extends FinalSecurityExerciseApplicationTests{

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setUsername("user");
        String encodePwd = Blowfish.encode("123");
        userDO.setPassword(encodePwd);
        userDO.setRole(UserRoleEnum.ROLE_USER);
        userRepository.save(userDO);

        UserDO userDO1 = new UserDO();
        userDO1.setUsername("admin");
        String encodePwd1 = Blowfish.encode("456");
        userDO1.setPassword(encodePwd1);
        userDO1.setRole(UserRoleEnum.ROLE_ADMIN);
        userRepository.save(userDO1);
    }

}