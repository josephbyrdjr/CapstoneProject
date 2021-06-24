package com.hcl.service.impl;

import java.util.List;

import com.hcl.dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Item;
import com.hcl.repository.ItemRepository;
import com.hcl.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;
	
	@Override
	public void insertItem(Item item) {
		itemDao.insertItem(item);
		
	}

	@Override
	public List<Item> getAllItems() {
		return itemDao.getAllItems();
	}

	@Override
	public Item getItemById(Long itemId) {
		return itemDao.getItemById(itemId);
	}

	@Override
	public void updateItem(Item item) {
		itemDao.updateItem(item);
		
	}

	@Override
	public void deleteItemById(long itemId) {
		itemDao.deleteItemById(itemId);
		
	}

}
