package com.hcl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dao.ShoppingCartDao;
import com.hcl.model.Item;
import com.hcl.model.ShoppingCart;
import com.hcl.repository.ShoppingCartRepository;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

	
	@Autowired
	ShoppingCartRepository shoppingCartRepo;

	@Override
	public void insertShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepo.save(shoppingCart);
		
	}

	@Override
	public void insertShoppingCart(List<ShoppingCart> shoppingCarts) {
		shoppingCartRepo.saveAll(shoppingCarts);
		
	}

	@Override
	public List<ShoppingCart> getAllShoppingCarts() {
		return shoppingCartRepo.findAll();
	}

	@Override
	public ShoppingCart getShoppingCartById(Long ShoppingCartId) {
		return shoppingCartRepo.findById(ShoppingCartId).orElse(null);
	}

	@Override
	public void updateShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepo.save(shoppingCart);
		
	}

	@Override
	public void deleteShoppingCartById(long shoppingCartId) {
		shoppingCartRepo.deleteById(shoppingCartId);
		
	}
}
