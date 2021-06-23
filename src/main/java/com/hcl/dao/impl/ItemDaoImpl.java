package com.hcl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dao.ItemDao;
import com.hcl.model.Item;
import com.hcl.repository.ItemRepository;

@Repository
public class ItemDaoImpl implements ItemDao {
	
	@Autowired
	ItemRepository itemRepo;
	
	@Override
	public void insertItem(Item item) {
		itemRepo.save(item);
		
	}

	@Override
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}

	@Override
	public Item getItemById(Long itemId) {
		return itemRepo.findById(itemId).orElse(null);
	}

	@Override
	public void updateItem(Item item) {
		itemRepo.save(item);
		
	}

	@Override
	public void deleteItemById(long itemId) {
		itemRepo.deleteById(itemId);
		
	}
}
