package com.hcl.controllers.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.service.ItemService;
import com.hcl.service.OrderService;
import com.hcl.service.UserService;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.model.User;

@RestController
public class OrderRestController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ItemService itemService;

	@Autowired
	OrderService orderService;
	
	@GetMapping("/order")
	private List<Order> getAllItems(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("order/{orderId}")
	private Order getOrder(@PathVariable(value = "orderId") long orderId) {
		return orderService.getOrderById(orderId);
	}
	
	@PostMapping("order")
	private void createOrder(@RequestBody Order order,
							 @RequestParam(name = "itemId") long itemId, 
							 @RequestParam(name = "userId") long userId
							 ) {
		System.out.println(1);
		
		User user = userService.getUserById(userId);
		Item item = itemService.getItemById(itemId);
		
		//Order order = new Order();
		order.setItem(item);
		order.setUser(user);
		orderService.insertOrder(order);
	}
	
	@PutMapping("order")
	private void updateOrder(@RequestBody Order order) {
		orderService.insertOrder(order);
	}
	
	@DeleteMapping("order/{orderId}")
	private void deleteOrder(@PathVariable(value = "orderId") long id) {
		orderService.deleteOrderById(id);
	}
	
}
