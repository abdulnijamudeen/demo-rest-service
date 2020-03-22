package com.example.nizam.app.data.service.user;

import java.util.List;
import java.util.Optional;

import com.example.nizam.app.data.entity.User;

public interface UserService {

    User saveUser(final User user);

    List<User> userList();

    User updateUser(final User user);

    User findUser(Long id);

    void removeUser(Long id);

    Optional<User> validateUserByUsername(String username);

}