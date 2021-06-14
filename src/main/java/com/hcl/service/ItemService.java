package com.hcl.service;

import java.util.List;

import com.hcl.model.Item;

public interface ItemService {

	void insertItem(Item item);
	void insertItems(List<Item> items);
	List<Item> getAllItems();
	Item getItemById(Long itemId);
	void updateItem(Item item);
	void deleteItemById(long itemId);
}
