package com.hcl.service;

import java.util.List;

import com.hcl.model.ShoppingCart;

public interface ShoppingCartService {

	void insertShoppingCart(ShoppingCart shoppingCart);
	void insertShoppingCart(List<ShoppingCart> shoppingCart);
	List<ShoppingCart> getAllShoppingCarts();
	ShoppingCart getShoppingCartById(Long shoppingCartId);
	void updateShoppingCart(ShoppingCart shoppingCart);
	void deleteShoppingCartById(long shoppingCartId);
	
}
