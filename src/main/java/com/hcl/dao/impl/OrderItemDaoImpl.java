package com.hcl.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hcl.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dao.OrderItemDao;
import com.hcl.repository.OrderItemRepository;

@Repository
public class OrderItemDaoImpl implements OrderItemDao {

	
	@Autowired
    OrderItemRepository orderItemRepository;

	@Override
	public void insertOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
		
	}

	@Override
	public void insertOrderItems(List<OrderItem> orderItems) {
		orderItemRepository.saveAll(orderItems);
		
	}

	@Override
	public Set<OrderItem> getAllOrderItems() {
		return new HashSet<>(orderItemRepository.findAll());
	}

	@Override
	public OrderItem getOrderItemById(long orderId) {
		return orderItemRepository.findById(orderId).orElse(null);
	}

	@Override
	public void updateOrderItem(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
		
	}

	@Override
	public void deleteOrderItemById(long orderId) {
		orderItemRepository.deleteById(orderId);
		
	}


	public OrderItem getOrderItemByOrderIdAndItemId(long orderId, long itemId){
		 return orderItemRepository.findOrderItemByOrderIdAndItemId(orderId, itemId);
	}
}
