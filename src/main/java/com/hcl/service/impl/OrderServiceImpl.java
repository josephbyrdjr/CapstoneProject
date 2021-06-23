package com.hcl.service.impl;

import java.util.List;

import com.hcl.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Order;
import com.hcl.repository.OrderRepository;
import com.hcl.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDao orderDao;
	
	@Override
	public void insertOrders(Order order) {
		orderDao.insertOrder(order);
		
	}

	@Override
	public void insertOrders(List<Order> order) {
		orderDao.insertOrders(order);
		
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public Order getOrderById(Long orderId) {
		return orderDao.getOrderById(orderId);
	}

	@Override
	public void updateOrder(Order order) {
		orderDao.updateOrder(order);
		
	}

	@Override
	public void deleteOrderById(long orderId) {
		orderDao.deleteOrderById(orderId);
		
	}

	public List<Order> getOrdersByUserId(Long id){
		return orderDao.getOrdersByUserId(id);
	}

	public Order getOrdersByUserIdAndItemId(long userId, long itemId){
		return orderDao.getOrdersByUserIdAndItemId(userId, itemId);
	}
}
