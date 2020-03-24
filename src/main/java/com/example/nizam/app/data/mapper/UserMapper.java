package com.example.nizam.app.data.mapper;

import com.example.nizam.app.data.entity.User;
import com.example.nizam.app.data.enumeration.UserRole;
import com.example.nizam.app.data.mapper.helper.EntityMapper;
import com.example.nizam.app.data.model.request.SignUp;
import com.example.nizam.app.data.util.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Component
@Qualifier("UserMapper")
@Log4j2
public class UserMapper implements EntityMapper<SignUp, User> {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User map(SignUp signUp) {
        LOG.info("Map SignUpRequest to Member Entity");
        User user = new User();
        user.setName(signUp.getName());
        user.setUsername(signUp.getUsername());
        user.setPassword(passwordEncoder.encode(signUp.getPassword()));
        user.setRole(UserRole.displayMatch(signUp.getRole()).getDisplay());
        user.setCreatedDate(AppUtils.getInstant());
        return user;
    }

}
