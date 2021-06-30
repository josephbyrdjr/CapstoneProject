package com.hcl.service;

import java.util.List;
import java.util.Set;

import com.hcl.model.OrderItem;

public interface OrderItemService {

	void insertOrderItem(OrderItem orderItem);
	void insertOrderItems(List<OrderItem> orderItem);
	Set<OrderItem> getAllOrdersItems();
	OrderItem getOrderItemById(Long orderId);
	void updateOrderItem(OrderItem orderItem);
	void deleteOrderItemById(long orderId);
	OrderItem getOrderItemByOrderIdAndItemId(long orderId, long itemId);
}
