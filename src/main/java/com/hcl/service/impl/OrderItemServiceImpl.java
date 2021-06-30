package com.hcl.service.impl;

import java.util.List;
import java.util.Set;

import com.hcl.dao.OrderItemDao;
import com.hcl.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
    OrderItemDao orderItemDao;
	
	@Override
	public void insertOrderItem(OrderItem orderItem) {
		orderItemDao.insertOrderItem(orderItem);
		
	}

	@Override
	public void insertOrderItems(List<OrderItem> orderItem) {
		orderItemDao.insertOrderItems(orderItem);
		
	}

	@Override
	public Set<OrderItem> getAllOrdersItems() {
		return orderItemDao.getAllOrderItems();
	}

	@Override
	public OrderItem getOrderItemById(Long orderId) {
		return orderItemDao.getOrderItemById(orderId);
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		orderItemDao.updateOrderItem(orderItem);
		
	}

	@Override
	public void deleteOrderItemById(long orderId) {
		orderItemDao.deleteOrderItemById(orderId);
		
	}

	@Override
	public OrderItem getOrderItemByOrderIdAndItemId(long orderId, long itemId) {
		return orderItemDao.getOrderItemByOrderIdAndItemId(orderId, itemId);
	}


}
