package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.ShoppingCart;
import com.hcl.repository.ShoppingCartRepository;
import com.hcl.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepo;
	
	@Override
	public void insertShoppingCart(ShoppingCart shoppingCart) {
		shoppingCartRepo.save(shoppingCart);
		
	}

	@Override
	public void insertShoppingCart(List<ShoppingCart> shoppingCart) {
		shoppingCartRepo.saveAll(shoppingCart);
		
	}

	@Override
	public List<ShoppingCart> getAllShoppingCarts() {
		return shoppingCartRepo.findAll();
	}

	@Override
	public ShoppingCart getShoppingCartById(Long shoppingCartId) {
		return shoppingCartRepo.findById(shoppingCartId).orElse(null);
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
