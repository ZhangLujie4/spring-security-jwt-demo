package com.zlj.final_security_exercise.dataobject;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;

/**
 * @author tori
 * 2018/7/30 上午11:02
 */
public class UserAuthentication implements Authentication {

    private final SecurityUser user;

    private boolean authenticated;

    public UserAuthentication(SecurityUser user) {
        this.user = user;
        /**
         * 这里可以从security里面传过来，这里为了方便默认为true
         */
        this.authenticated = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return "";
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.authenticated = isAuthenticated;
    }

    @Override
    public String getName() {
        return user.getUsername();
    }

    public Long getUserId() {
        return user.getUserId();
    }
}
