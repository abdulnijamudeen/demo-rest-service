package com.example.nizam.app.data.service;

import java.util.List;

import com.example.nizam.app.data.entity.Item;

public interface ItemService {

    Item saveItem(final Item item);

    List<Item> itemList();

    List<Item> itemListOrderedByHighestPrice();

    Item updateItem(final Item item);

    Item findItem(Long id);

    void removeItem(Long id);

}