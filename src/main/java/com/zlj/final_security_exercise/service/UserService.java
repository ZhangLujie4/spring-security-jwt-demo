package com.zlj.final_security_exercise.service;

import com.zlj.final_security_exercise.dataobject.UserDO;
import com.zlj.final_security_exercise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tori
 * 2018/7/30 下午12:35
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDO findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<UserDO> findAll() {
        return userRepository.findAll();
    }

}
