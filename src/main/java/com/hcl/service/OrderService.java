package com.hcl.service;

import java.util.List;

import com.hcl.model.Order;

public interface OrderService {

	void insertOrder(Order order);
	void insertOrder(List<Order> order);
	List<Order> getAllOrders();
	Order getOrderById(Long orderId);
	void updateOrder(Order order);
	void deleteOrderById(long orderId);
	
}
