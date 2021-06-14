package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Item;
import com.hcl.repository.ItemRepository;
import com.hcl.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepo;
	
	@Override
	public void insertItem(Item item) {
		itemRepo.save(item);
		
	}

	@Override
	public void insertItems(List<Item> items) {
		itemRepo.saveAll(items);
		
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
