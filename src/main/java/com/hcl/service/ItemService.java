package com.hcl.service;

import java.util.List;

import com.hcl.model.Item;

public interface ItemService {

	void insertItem(Item item);
	List<Item> getAllItems();
	Item getItemById(Long itemId);
	void updateItem(Item item);
	void deleteItemById(long itemId);
}
