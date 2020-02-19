package com.example.nizam.app.controller;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import com.example.nizam.app.data.entity.Item;
import com.example.nizam.app.data.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/items")
@Api(value = "Item Controller")
public class ItemController {

    @Autowired
    ItemService itemService;

    @ApiOperation("List of all items")
    @GetMapping()
    public ResponseEntity<List<Item>> listAllItems() {
        List<Item> items = itemService.itemListOrderedByHighestPrice();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @ApiOperation("Add new Item")
    @PostMapping()
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        item.setItemId(null);
        item.setCreatedDate(Date.from(Instant.now()));
        Item saveditem = itemService.saveItem(item);
        return new ResponseEntity<>(saveditem, HttpStatus.OK);
    }

    @ApiOperation("Get item by Item Id")
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@ApiParam("Item Id") @PathVariable Long id) {
         Item item = itemService.findItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @ApiOperation("Remove item by Item Id")
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Item>> removeItem(@ApiParam("Item Id") @PathVariable Long id) {
        itemService.removeItem(id);
         List<Item> items = itemService.itemListOrderedByHighestPrice();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

}