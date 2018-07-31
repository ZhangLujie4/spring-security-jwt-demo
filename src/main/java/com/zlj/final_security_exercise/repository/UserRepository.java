package com.zlj.final_security_exercise.repository;

import com.zlj.final_security_exercise.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tori
 * 2018/7/30 下午12:30
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {

    UserDO findByUsername(String username);
}
