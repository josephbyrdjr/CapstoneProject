package com.hcl.dao;

import java.util.List;

import com.hcl.model.Item;
import com.hcl.model.Order;

public interface OrderDao {

	void insertOrder(Order order);
	void insertOrders(List<Order> orders);
	List<Order> getAllOrders();
	Order getOrderById(long orderId);
	void updateOrder(Order order);
	void deleteOrderById(long orderId);
	List<Order> getOrdersByUserId(long id);
	Order getOrdersByUserIdAndItemId(long userId, long itemId);
}
