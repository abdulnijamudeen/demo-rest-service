package com.example.nizam.app.controller;

import com.example.nizam.app.data.mapper.UserMapper;
import com.example.nizam.app.data.model.request.SignUp;
import com.example.nizam.app.data.model.response.ResponseStatus;
import com.example.nizam.app.data.model.response.UserResponse;
import com.example.nizam.app.data.service.user.UserService;
import com.example.nizam.app.data.util.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.var;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping(value = "/api/auth")
@Api(value = "Auth Controller")
@Log4j2
public class AuthController extends BaseController {

    @Autowired
    @Qualifier("UserMapper")
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @ApiOperation("Add new User")
    @PostMapping("/sign-up")
    public ResponseEntity<ResponseStatus> addNewUser(@RequestBody SignUp signUp) {
        var userOptional = userService.validateUserByUsername(signUp.getUsername());
        if(userOptional.isPresent()){
            LOG.info("User Already Exist");
            return new ResponseEntity<>(new ResponseStatus("User Already Exist"), HttpStatus.OK);
        }
        LOG.info("Added new user");
        userService.saveUser(userMapper.map(signUp));
        return new ResponseEntity<>(new ResponseStatus("Success"), HttpStatus.OK);
    }

    @ApiOperation("User login API")
    @PostMapping(value = "/login", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseStatus> login( @RequestParam String username, @RequestParam String password) {
        throw new IllegalStateException("It's implemented by Spring Security.");
    }

    @ApiOperation(value = "Authentication Success Forward URL.", hidden = true)
    @PostMapping("/success")
    public ResponseEntity<UserResponse> getAuthenticatedUser() {
        LOG.info("Authentication Success Forward URL - AuthController");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("No user logged in.");
        }
        var savedUser = AppUtils.getCurrentUser();
        return new ResponseEntity<>(userResponse(savedUser), HttpStatus.OK);
    }

    @ApiOperation("User logout API")
    @PostMapping("/logout")
    public ResponseEntity<ResponseStatus> logout() {
        throw new IllegalStateException("It's implemented by Spring Security.");
    }

    @ApiOperation(value = "Logout Success Forward URL", hidden = true)
    @PostMapping("/clear")
    public ResponseEntity<ResponseStatus> clearLogout() {
        return new ResponseEntity<>(new ResponseStatus("User Logged out"), HttpStatus.OK);
    }


}