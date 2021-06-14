package com.hcl.dao;

import java.util.List;

import com.hcl.model.Item;
import com.hcl.model.ShoppingCart;

public interface ShoppingCartDao {

	void insertShoppingCart(ShoppingCart shoppingCart);
	void insertShoppingCart(List<ShoppingCart> shoppingCarts);
	List<ShoppingCart> getAllShoppingCarts();
	ShoppingCart getShoppingCartById(Long ShoppingCartId);
	void updateShoppingCart(ShoppingCart shoppingCart);
	void deleteShoppingCartById(long shoppingCartId);
}
