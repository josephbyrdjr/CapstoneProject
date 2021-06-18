package com.hcl.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.dao.OrderDao;
import com.hcl.model.Item;
import com.hcl.model.Order;
import com.hcl.repository.OrderRepository;

@Repository
public class OrderDaoImpl implements OrderDao {

	
	@Autowired
	OrderRepository orderRepo;

	@Override
	public void insertOrder(Order order) {
		orderRepo.save(order);
		
	}

	@Override
	public void insertOrders(List<Order> orders) {
		orderRepo.saveAll(orders);
		
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(long orderId) {
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

	public List<Order> getOrdersByUserId(Long id){
		return orderRepo.findOrdersByUserId(id);
	}
}
