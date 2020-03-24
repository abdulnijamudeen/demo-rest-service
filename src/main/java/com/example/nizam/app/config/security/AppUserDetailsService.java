package com.example.nizam.app.config.security;

import java.util.ArrayList;
import java.util.List;

import com.example.nizam.app.data.enumeration.UserRole;
import com.example.nizam.app.data.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.var;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Transactional
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("AppUserDetailsService");
        var userOptional  = userService.validateUserByUsername(username);
        if(!userOptional.isPresent()) {
            throw new UsernameNotFoundException("Invalid username / User not exist");
        }
        var user = userOptional.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(UserRole.displayMatch(user.getRole()).getRole()));
        return new AppUserDetails(user, user.getPassword(), authorities);
    }

}