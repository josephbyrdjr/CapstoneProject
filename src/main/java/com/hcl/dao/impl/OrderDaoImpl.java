package com.hcl.dao.impl;

import com.hcl.dao.OrderDao;
import com.hcl.model.Order;
import com.hcl.model.OrderItem;
import com.hcl.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    OrderRepository orderRepository;

    public void insertOrder(Order order){
        orderRepository.save(order);
    }
    public void insertOrders(List<Order> orders){
        orderRepository.saveAll(orders);
    }
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Order getOrderById(long orderId){
        return orderRepository.findById(orderId).orElse(null);
    }
    public void updateOrder(Order order){
        orderRepository.save(order);
    }
    public void deleteOrderById(long orderId){
        orderRepository.deleteById(orderId);
    }
    public Order getOrderByStatusAndUserId(String status, long userId) {
        return orderRepository.findOrderByStatusAndUserId(status, userId);
    }
}
