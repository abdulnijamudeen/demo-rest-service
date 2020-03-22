package com.example.nizam.app.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class AppUserDetails extends User {

    private com.example.nizam.app.data.entity.User currentUser;

    public AppUserDetails(com.example.nizam.app.data.entity.User user, String password, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUsername(), password, authorities);
        this.currentUser = user;
    }

    public com.example.nizam.app.data.entity.User getCurrentUser() {
        return currentUser;
    }

}