package com.hcl.controllers.rest;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Item;
import com.hcl.service.ItemService;

@RestController
public class ItemRestController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/item")
	private List<Item> getAllItems(){
		return itemService.getAllItems();
	}
	
	@GetMapping("item/{itemId}")
	private Item getItem(@PathVariable(value = "itemId") long itemId) {
		return itemService.getItemById(itemId);
	}
	
	@PostMapping("item")
	private void createItem(@RequestBody Item item) {
		itemService.insertItem(item);
	}
	
	@PutMapping("item")
	private void updateUser(@RequestBody Item item) {
		itemService.insertItem(item);
	}
	
	@DeleteMapping("item/{itemId}")
    private void deleteItem(@PathVariable(name = "itemId") long id){
        itemService.deleteItemById(id);
    }

}
