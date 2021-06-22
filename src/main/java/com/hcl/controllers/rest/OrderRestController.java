package com.hcl.controllers.rest;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	
	private static List<Order> allOrders;

	@GetMapping("/order")
	private List<Order> getAllItems() {
		return orderService.getAllOrders();
	}

	@GetMapping("order/{orderId}")
	private Order getOrder(@PathVariable(value = "orderId") long orderId) {
		return orderService.getOrderById(orderId);
	}

	@PostMapping("order")
	private void createOrder(@RequestParam(name = "quantity") int quantity, @RequestParam(name = "itemId") long itemId,
			HttpServletResponse response) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.getUserByUsername(auth.getName());
		Item item = itemService.getItemById(itemId);

		Order order = new Order();
		order.setQuantity(quantity);
		order.setItem(item);
		order.setUser(user);
		orderService.insertOrder(order);
		response.sendRedirect("/catalog");
	}

	@PostMapping("/updateOrder")
	private void updateOrder(@RequestParam long orderId, @RequestParam int quantity, HttpServletResponse response)
			throws IOException {
		Order order = orderService.getOrderById(orderId);
		order.setQuantity(quantity);
		orderService.insertOrder(order);
		response.sendRedirect("/order/shoppingCart");

	}

	@GetMapping("deleteOrder/{orderId}")
	private void deleteOrder(@PathVariable(value = "orderId") long id, HttpServletResponse response)
			throws IOException {
		orderService.deleteOrderById(id);
		response.sendRedirect("/order/shoppingCart");
	}
	

}
