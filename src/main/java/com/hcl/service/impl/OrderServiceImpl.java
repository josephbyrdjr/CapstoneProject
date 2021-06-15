package com.hcl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Order;
import com.hcl.repository.OrderRepository;
import com.hcl.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Override
	public void insertOrder(Order order) {
		orderRepo.save(order);
		
	}

	@Override
	public void insertOrder(List<Order> order) {
		orderRepo.saveAll(order);
		
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(Long orderId) {
		return orderRepo.findById(orderId).orElse(null);
	}

	@Override
	public void updateOrder(Order order) {
		orderRepo.save(order);
		
	}

	@Override
	public void deleteOrderById(long orderId) {
		orderRepo.deleteById(orderId);
		
	}

}
