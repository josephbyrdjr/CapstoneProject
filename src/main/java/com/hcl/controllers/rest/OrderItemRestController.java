package com.hcl.controllers.rest;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.hcl.model.Order;
import com.hcl.model.OrderItem;
import com.hcl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.service.ItemService;
import com.hcl.service.OrderItemService;
import com.hcl.service.UserService;
import com.hcl.model.Item;
import com.hcl.model.User;

@RestController
public class OrderItemRestController {

	@Autowired
	UserService userService;

	@Autowired
	ItemService itemService;

	@Autowired
    OrderItemService orderItemService;

	@Autowired
	OrderService orderService;
	
	private static List<OrderItem> allOrderItems;

	@GetMapping("/orderItem")
	private Set<OrderItem> getAllItems() {
		return orderItemService.getAllOrdersItems();
	}

	@GetMapping("/orderItem/{orderId}")
	private OrderItem getOrder(@PathVariable(value = "orderId") long orderId) {
		return orderItemService.getOrderItemById(orderId);
	}

	@PostMapping("/orderItem")
	private void createOrder(@RequestParam(name = "quantity") int quantity, @RequestParam(name = "itemId") long itemId,
			HttpServletResponse response) throws IOException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = userService.getUserByUsername(auth.getName());
		Order order = orderService.getActiveOrder(user.getId());
		if(order == null){
			orderService.insertOrder(new Order("ACTIVE", user));
			order = orderService.getActiveOrder(user.getId());
		}
		Item item = itemService.getItemById(itemId);
		if(item == null){
			response.sendError(400);
		} else {
			if (orderItemService.getOrderItemByOrderIdAndItemId(order.getId(), itemId) == null) {
				OrderItem orderItem = new OrderItem();
				orderItem.setQuantity(quantity);
				orderItem.setItem(item);
				orderItem.setOrder(order);
				orderItemService.insertOrderItem(orderItem);
			} else {
				OrderItem orderItem = orderItemService.getOrderItemByOrderIdAndItemId(order.getId(), itemId);
				orderItem.setQuantity(orderItem.getQuantity() + quantity);
				orderItemService.updateOrderItem(orderItem);
			}
			response.sendRedirect("/catalog");
		}
	}

	@PostMapping("/updateOrderItem")
	private void updateOrder(@RequestParam long orderId, @RequestParam int quantity, HttpServletResponse response)
			throws IOException {
		OrderItem orderItem = orderItemService.getOrderItemById(orderId);
		orderItem.setQuantity(quantity);
		orderItemService.insertOrderItem(orderItem);
		response.sendRedirect("/orderItem/shoppingCart");

	}

	@GetMapping("/deleteOrderItem/{orderItemId}")
	private void deleteOrder(@PathVariable(value = "orderItemId") long id, HttpServletResponse response)
			throws IOException {
		orderItemService.deleteOrderItemById(id);
		response.sendRedirect("/orderItem/shoppingCart");
	}
	

}
