package com.example.nizam.app.data.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.nizam.app.data.entity.Item;
import com.example.nizam.app.data.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public Item findItem(Long id) {
        Optional<Item> optionalItem = itemRepository.findById(id);
        if (optionalItem.isPresent()) {
            return optionalItem.get();
        }
        return null;
    }

    @Override
    public List<Item> itemList() {
        return itemRepository.findAll();
    }

    @Override
    public void removeItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> itemListOrderedByHighestPrice() {
        return itemRepository.findAll().stream().sorted(Comparator.comparing(Item::getPrice).reversed()).collect(Collectors.toList());
    }
    
}