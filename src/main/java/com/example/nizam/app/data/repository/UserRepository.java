package com.example.nizam.app.data.repository;

import java.util.Optional;

import com.example.nizam.app.data.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);
    
}