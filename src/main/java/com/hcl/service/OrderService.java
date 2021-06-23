package com.hcl.service;

import java.util.List;

import com.hcl.model.Order;

public interface OrderService {

	void insertOrders(Order order);
	void insertOrders(List<Order> order);
	List<Order> getAllOrders();
	Order getOrderById(Long orderId);
	void updateOrder(Order order);
	void deleteOrderById(long orderId);
	List<Order> getOrdersByUserId(Long id);
	Order getOrdersByUserIdAndItemId(long userId, long itemId);
}
