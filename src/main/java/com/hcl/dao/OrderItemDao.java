package com.hcl.dao;

import java.util.List;
import java.util.Set;

import com.hcl.model.Order;
import com.hcl.model.OrderItem;

public interface OrderItemDao {

	void insertOrderItem(OrderItem orderItem);
	void insertOrderItems(List<OrderItem> orderItems);
	Set<OrderItem> getAllOrderItems();
	OrderItem getOrderItemById(long orderId);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItemById(long orderId);
	OrderItem getOrderItemByOrderIdAndItemId(long orderId, long itemId);
}
