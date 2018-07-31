package com.zlj.final_security_exercise.utils;

import com.zlj.final_security_exercise.dataobject.SecurityUser;
import com.zlj.final_security_exercise.dataobject.UserDO;
import com.zlj.final_security_exercise.dataobject.UserRoleEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author tori
 * 2018/7/30 上午11:43
 */
public class SecurityUtil {

    public static SecurityUser convertUser(UserDO userDO) {
        Collection<GrantedAuthority> authorities = new HashSet<>();
        if (userDO.getRole().equals(UserRoleEnum.ROLE_ADMIN)) {
            authorities.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_ADMIN.toString()));
            authorities.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_USER.toString()));
        }
        if (userDO.getRole().equals(UserRoleEnum.ROLE_USER)) {
            authorities.add(new SimpleGrantedAuthority(UserRoleEnum.ROLE_USER.toString()));
        }

        SecurityUser user = new SecurityUser(userDO.getId(), userDO.getUsername(), authorities);

        return user;
    }

    public static SecurityUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            return (SecurityUser) authentication.getPrincipal();
        }

        return null;
    }
}
