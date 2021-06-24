package com.hcl.dao;

import java.util.List;

import com.hcl.model.Item;

public interface ItemDao {
	
	void insertItem(Item item);
	List<Item> getAllItems();
	Item getItemById(Long itemId);
	void updateItem(Item item);
	void deleteItemById(long itemId);

}
