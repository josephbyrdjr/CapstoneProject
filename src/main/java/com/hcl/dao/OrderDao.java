package com.hcl.dao;

import com.hcl.model.Order;
import com.hcl.model.OrderItem;

import java.util.List;

public interface OrderDao {

    void insertOrder(Order order);
    void insertOrders(List<Order> order);
    List<Order> getAllOrders();
    Order getOrderById(long orderId);
    void updateOrder(Order order);
    void deleteOrderById(long orderId);
    Order getOrderByStatusAndUserId(String status, long userId);
}
