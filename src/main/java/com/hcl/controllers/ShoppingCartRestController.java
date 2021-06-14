package com.hcl.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.service.ShoppingCartService;
import com.hcl.model.ShoppingCart;

@RestController
public class ShoppingCartRestController {

	@Autowired
	ShoppingCartService shoppingCartService;
	
	@GetMapping("/shoppingCart")
	private List<ShoppingCart> getAllItems(){
		return shoppingCartService.getAllShoppingCarts();
	}
	
	@GetMapping("shoppingCart/{shoppingCartId}")
	private ShoppingCart getShoppingCart(@PathVariable(value = "shoppingCartId") long shoppingCartId) {
		return shoppingCartService.getShoppingCartById(shoppingCartId);
	}
	
	@PostMapping("shoppingCart")
	private void createShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		shoppingCartService.insertShoppingCart(shoppingCart);
	}
	
	@PutMapping("shoppingCart")
	private void updateUser(@RequestBody ShoppingCart shoppingCart) {
		shoppingCartService.insertShoppingCart(shoppingCart);
	}
	
	@DeleteMapping("shoppingCart/{shoppingCartId}")
	private void deleteShoppingCart(@PathVariable(value = "shoppingCartId") long id) {
		shoppingCartService.deleteShoppingCartById(id);
	}
	
}
