package com.example.nizam.app.data.repository;

import java.util.Optional;

import com.example.nizam.app.data.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findById(Long id);
    
}