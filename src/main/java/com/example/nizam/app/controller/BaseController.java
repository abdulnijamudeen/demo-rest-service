package com.example.nizam.app.controller;


import java.util.List;
import java.util.stream.Collectors;

import com.example.nizam.app.data.entity.User;
import com.example.nizam.app.data.model.response.UserResponse;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BaseController {

   protected UserResponse userResponse(User user)  { return copy(user); }
   
   protected List<UserResponse> customerResponse(List<User> userList) { return userList.stream().map(o -> copy(o)).collect(Collectors.toList()); }

   private UserResponse copy(User user) {
    LOG.info("Copy user entity");
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(String.valueOf(user.getUserId()));
        userResponse.setName(user.getName());
        userResponse.setUsername(user.getUsername());
        userResponse.setRole(user.getRole());
       return userResponse;
   }


}