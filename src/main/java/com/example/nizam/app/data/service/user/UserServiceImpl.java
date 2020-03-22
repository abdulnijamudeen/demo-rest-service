package com.example.nizam.app.data.service.user;

import java.util.List;
import java.util.Optional;

import com.example.nizam.app.data.entity.User;
import com.example.nizam.app.data.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> validateUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
}