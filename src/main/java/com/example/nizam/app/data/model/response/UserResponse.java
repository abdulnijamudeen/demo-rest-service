package com.example.nizam.app.data.model.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter @SuppressWarnings("serial")
public class UserResponse implements Serializable {
    private String userId;
    private String name;
    private String username;
    private String role;
    private String token;
}